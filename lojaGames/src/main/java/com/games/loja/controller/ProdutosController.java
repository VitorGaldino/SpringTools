package com.games.loja.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.games.loja.model.Produtos;
import com.games.loja.repository.CategoriasRepository;
import com.games.loja.repository.ProdutosRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "", allowedHeaders = "")
public class ProdutosController {

    @Autowired
    private ProdutosRepository produtosRepository;
    
    @Autowired
    private CategoriasRepository categoriasRepository;

    @GetMapping
    public ResponseEntity<List<Produtos>> getAll(){
        return ResponseEntity.ok(produtosRepository.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Produtos> getById (@PathVariable Long id) {
    	return produtosRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
    			.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produtos>> getByTitulo (@PathVariable String nome) {
    	return ResponseEntity.ok(produtosRepository.findAllByNomeContainingIgnoreCase(nome));
    }
    
    @PostMapping
    public ResponseEntity<Produtos> post (@Valid @RequestBody Produtos produtos) {
    	if (categoriasRepository.existsById(produtos.getCategorias().getId()))
    	return ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produtos));
    	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    
    @PutMapping
    public ResponseEntity<Produtos> put(@Valid @RequestBody Produtos produtos){
		if (produtosRepository.existsById(produtos.getId())){
			
			if (categoriasRepository.existsById(produtos.getCategorias().getId()))
				return ResponseEntity.status(HttpStatus.OK)
						.body(produtosRepository.save(produtos));
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
		}			
			
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Produtos> produtos = produtosRepository.findById(id);
		
		if(produtos.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		produtosRepository.deleteById(id);				
	}

}
