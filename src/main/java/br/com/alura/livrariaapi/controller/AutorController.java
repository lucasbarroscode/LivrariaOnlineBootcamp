package br.com.alura.livrariaapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.livrariaapi.dto.AutorDto;
import br.com.alura.livrariaapi.dto.AutorFormDto;
import br.com.alura.livrariaapi.modelo.Autor;
import br.com.alura.livrariaapi.service.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {
	

	
	@Autowired
	private AutorService service;
	
	@GetMapping
	public Page<AutorDto> listar(@PageableDefault(size=10)Pageable paginacao) {
		return service.listar(paginacao);
		 
	}
	
	//RequestBody para saber de onde vem a requisição e fazer o cadastro
	//@Valid aqui define a onde o Spring precisa validar se o qeu colocamso na classe Form está correto
	@PostMapping
	public void cadastrar(@RequestBody @Valid AutorFormDto dto) {
		service.cadastrar(dto);
		
	}

}
