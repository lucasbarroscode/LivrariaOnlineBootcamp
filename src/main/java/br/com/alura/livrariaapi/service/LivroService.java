package br.com.alura.livrariaapi.service;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.livrariaapi.dto.AtualizacaoLivroFormDto;
import br.com.alura.livrariaapi.dto.LivroDto;
import br.com.alura.livrariaapi.dto.LivroFormDto;
import br.com.alura.livrariaapi.modelo.Autor;
import br.com.alura.livrariaapi.modelo.Livro;
import br.com.alura.livrariaapi.modelo.Usuario;
import br.com.alura.livrariaapi.repository.AutorRepository;
import br.com.alura.livrariaapi.repository.LivroRepository;
import br.com.alura.livrariaapi.repository.UsuarioRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	public Page<LivroDto> listar(Pageable paginacao) {
		return livroRepository
				//.findAllByAutor(paginacao, escritor)
				.findAll(paginacao)
				.map(t -> modelMapper.map(t, LivroDto.class));
		
		//testar dessa maneira
		//return livroRepository.findAll(paginacao).map(t -> modelMapper.map(t, LivroDto.class));
		
	}

	@Transactional
	//public LivroDto cadastrar(LivroFormDto dto, Autor escritor) {
	public LivroDto cadastrar(LivroFormDto dto) {
		
//		Long idAutor = dto.getAutorId();
//		Long idUsuario = dto.getUsuarioId();
		
		try{
			
			
//			Usuario usuario = usuarioRepository.getById(dto.getUsuarioId());
//			if (!usuario.equals(logado)) {
//				lancarErroAcessoNegado();
//			}
			
			//Autor autor = autorRepository.getById(idAutor);
			Autor autor = autorRepository.getById(dto.getAutorId());
			
			
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

	
	@Transactional
	public void remover(Long id) {
		Livro livro = livroRepository.getById(id);
		
		livroRepository.deleteById(id);
		
	}

	public LivroDto detalhar(Long id) {
		
		Livro livro = livroRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
		
		
		
		return modelMapper.map(livro, LivroDto.class);
	}
	
	private void lancarErroAcessoNegado() {
		throw new AccessDeniedException("Acesso Negado!");
	}
}
