package br.com.alura.livrariaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaapi.dto.ItemLivroDto;
import br.com.alura.livrariaapi.repository.LivroRepository;

@Service
public class RelatorioService {

	@Autowired
	private LivroRepository repository;
	
	public List<ItemLivroDto> relatorioDeLivros() {
		return repository.relatorioDeLivros();
	}

}
