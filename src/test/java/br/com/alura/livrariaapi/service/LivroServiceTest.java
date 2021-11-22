//package br.com.alura.livrariaapi.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//import java.time.LocalDate;
//
//import javax.persistence.EntityNotFoundException;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import br.com.alura.livrariaapi.dto.LivroDto;
//import br.com.alura.livrariaapi.dto.LivroFormDto;
//import br.com.alura.livrariaapi.modelo.Autor;
//import br.com.alura.livrariaapi.modelo.Usuario;
//import br.com.alura.livrariaapi.repository.AutorRepository;
//import br.com.alura.livrariaapi.repository.LivroRepository;
//import br.com.alura.livrariaapi.repository.UsuarioRepository;
//
//@ExtendWith(MockitoExtension.class)
//class LivroServiceTest {
//	
//	@Mock
//	private LivroRepository livroRepository;
//	
//	@Mock
//	private AutorRepository autorRepository;
//	
//	@Mock
//	private UsuarioRepository usuarioRepository;
//	
//	@InjectMocks
//	private LivroService service;
//	
//	//private Usuario logado;
//	
//	//private Autor escritor;
//
//	@Test
//	void deveriaCadastrarUmLivro() {
//		
//		LivroFormDto formDto = new LivroFormDto(
//				"Nome do Livro",
//				LocalDate.now(),
//				101,
//				1l
//				);
//		
////		Mockito
////		.when(usuarioRepository.getById(formDto.getUsuarioId()))
////		.thenReturn(logado);
//		
//		Mockito
//		.when(autorRepository
//				.getById(formDto.getAutorId()))
//		.thenReturn(new Autor(formDto.getAutorId(), "Fulano", "Fulano@email.com", LocalDate.now(), "Teste"));
//		
//		LivroDto dto = service.cadastrar(formDto);
//		
//		assertEquals(formDto.getTitulo(), dto.getTitulo());
//		assertEquals(formDto.getDataLancamento(), dto.getDataLancamento());
//		assertEquals(formDto.getNumPaginas(), dto.getNumPaginas());
//		assertEquals(formDto.getAutorId(), dto.getAutor().getId());
//	}
//	
//	@Test
//	void naodeveriaCadastrarUmLivroComAutorInexistente() {
//		
//		LivroFormDto formDto = new LivroFormDto(
//				"Nome do Livro",
//				LocalDate.now(),
//				101,
//				6l
//				);
//		
//		//Mockito.when(usuarioRepository.getById(formDto.getUsuarioId())).thenThrow(EntityNotFoundException.class);
//		
//		Mockito
//		.when(autorRepository.getById(formDto.getAutorId()))
//		.thenThrow(EntityNotFoundException.class);
//		
//		assertThrows(IllegalArgumentException.class, () -> service.cadastrar(formDto));
//		
//		
//	}
//
//}
