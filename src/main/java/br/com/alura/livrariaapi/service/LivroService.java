package br.com.alura.livrariaapi.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import br.com.alura.livrariaapi.dto.AtualizacaoLivroFormDto;
import br.com.alura.livrariaapi.dto.LivroDto;
import br.com.alura.livrariaapi.dto.LivroFormDto;
import br.com.alura.livrariaapi.modelo.Autor;
import br.com.alura.livrariaapi.modelo.Livro;
import br.com.alura.livrariaapi.repository.AutorRepository;
import br.com.alura.livrariaapi.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private AutorRepository autorRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	public Page<LivroDto> listar(Pageable paginacao) {
		Page<Livro> livros = livroRepository.findAll(paginacao);
		return livros.map(t -> modelMapper.map(t, LivroDto.class));
		
		//testar dessa maneira
		//return livroRepository.findAll(paginacao).map(t -> modelMapper.map(t, LivroDto.class));
		
	}

	@Transactional
	public LivroDto cadastrar(LivroFormDto dto) {
		
		Long idAutor = dto.getAutorId();
		
		try{
			
			Autor autor = autorRepository.getById(idAutor);
			
			Livro livro = modelMapper.map(dto, Livro.class);
			livro.setId(null);
			livro.setAutor(autor);
			
			livroRepository.save(livro);
			
			return modelMapper.map(livro, LivroDto.class);
			
		}catch (EntityNotFoundException e) {
			throw new IllegalArgumentException("Usuario inexistente");
		}
		

	}

	@Transactional
	public LivroDto atualizar(@Valid AtualizacaoLivroFormDto dto) {
		Livro livro = livroRepository.getById(dto.getAutorId());
		
		livro.atualizarInformacoes(dto.getTitulo(), dto.getDataLancamento(), dto.getNumPaginas());
		return modelMapper.map(livro, LivroDto.class);
	}

	public void remover(Long id) {
		livroRepository.deleteById(id);
		
	}

	public LivroDto detalhar(Long id) {
		
		Livro transacao = livroRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
		
		return modelMapper.map(transacao, LivroDto.class);
	}
}
