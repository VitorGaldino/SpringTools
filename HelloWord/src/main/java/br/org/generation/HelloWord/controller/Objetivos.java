package br.org.generation.HelloWord.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Objetivos {
	
	
	@GetMapping
	public String Objetivos3() {
		return "Olá Generation!\n"+"Meu objetivo nessa semana é desenvolver a habilidade com o STS é MySql para formar um bom BACK-END!";
		
		
	}

}
