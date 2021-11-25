package br.com.alura.livrariaapi.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.alura.livrariaapi.dto.ItemLivroDto;
import br.com.alura.livrariaapi.modelo.Autor;
import br.com.alura.livrariaapi.modelo.Livro;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
class LivroRepositoryTest {

	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	void deveriaRetornarRelatorio() {
		
		Autor autor = new Autor("Lucas Barros", "Lucas@teste", LocalDate.now(), "Teste");
		em.persist(autor);
		
		Livro l1 = new Livro(
				"Aprenda Java", 
				LocalDate.now(),
				101, 
				autor);
		em.persist(l1);
		
		Livro l2 = new Livro(
				"Como ser mais Produtivo", 
				LocalDate.now(),
				102, 
				autor);
		em.persist(l2);
		
		Livro l3 = new Livro(
				"Aprenda a falar em publico", 
				LocalDate.now(),
				103, 
				autor);
		em.persist(l3);
		
		Livro l4 = new Livro(
				"Como fazer bolos", 
				LocalDate.now(),
				104, 
				autor);
		em.persist(l4);
		
		Livro l5 = new Livro(
				"Investindo na bolsa", 
				LocalDate.now(),
				105, 
				autor);
		em.persist(l5);
		
		List<ItemLivroDto> relatorio = repository.relatorioDeLivros();
		Assertions.assertThat(relatorio)
		.hasSize(5)
		.extracting(ItemLivroDto::getNome, ItemLivroDto::getAutor_id, ItemLivroDto::getPercentual)
		.containsExactlyInAnyOrder(
//				Assertions.tuple("Andre da Silva", 1l, 20.0),
//				Assertions.tuple("Fernanda Nogueira", 2l, 30.0),
//				Assertions.tuple("Juliana Carvalho", 3l, 10.0),
//				Assertions.tuple("Rita de Assis", 4l, 10.0),
//				Assertions.tuple("Rodrigo de Souza", 5l, 10.0)
				Assertions.tuple("Lucas Barros", 1l, 20.0),
				Assertions.tuple("Lucas Barros", 2l, 20.0),
				Assertions.tuple("Lucas Barros", 3l, 20.0),
				Assertions.tuple("Lucas Barros", 4l, 20.0),
				Assertions.tuple("Lucas Barros", 5l, 20.0)
				);
	}

}
