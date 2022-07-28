package br.org.generation.HelloWord.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Hello")// Diz endereço onde será acessado localhost:8080/hello
public class HelloWord {
	
	@GetMapping //coloque a informação abaixo no endereço
	public String hello() {
		return "Hello Word! Hello Spring!";
		
		
	}

}

