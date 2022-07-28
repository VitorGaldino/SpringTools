package br.org.generation.HelloWord.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("BSMS")
public class BSMS {
	
	@GetMapping
	public String BSMS2() {
		return "Olá Generation!\n"+"Lista das bsms do dia foi entregavél urgente, novas habilidaes é aprender é compartilhar";
		
	}

}
