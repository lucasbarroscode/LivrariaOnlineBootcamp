package br.com.alura.livrariaapi.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.livrariaapi.dto.AutorDto;
import br.com.alura.livrariaapi.dto.AutorFormDto;
import br.com.alura.livrariaapi.service.AutorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/autores")
@Api(tags = "Autor")
public class AutorController {
	

	
	@Autowired
	private AutorService service;
	
	@GetMapping
	@ApiOperation("Listar Autores")
	public Page<AutorDto> listar(@PageableDefault(size=10)Pageable paginacao) {
		return service.listar(paginacao);
		 
	}
	
	//RequestBody para saber de onde vem a requisição e fazer o cadastro
	//@Valid aqui define a onde o Spring precisa validar se o qeu colocamso na classe Form está correto
	@PostMapping
	@ApiOperation("Cadastrar novos autores")
	public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorFormDto dto, UriComponentsBuilder uriBuilder) {
		AutorDto autorDto = service.cadastrar(dto);
		
		URI uri = uriBuilder
				.path("/autores/{id}")
				.buildAndExpand(autorDto.getId())
				.toUri();
		return ResponseEntity.created(uri).body(autorDto);
		
	}

}
