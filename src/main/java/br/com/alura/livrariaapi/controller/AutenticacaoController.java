package br.com.alura.livrariaapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.alura.livrariaapi.dto.LoginFormDto;
import br.com.alura.livrariaapi.dto.TokenDto;
import br.com.alura.livrariaapi.infra.security.AutenticacaoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AutenticacaoService service;

	
	@PostMapping
	public TokenDto autenticar(@RequestBody @Valid LoginFormDto dto) {
		return new TokenDto (service.autenticar(dto));	
		
		
		
	}
	
}