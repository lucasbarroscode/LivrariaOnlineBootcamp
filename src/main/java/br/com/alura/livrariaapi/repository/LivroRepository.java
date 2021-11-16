package br.com.alura.livrariaapi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import br.com.alura.livrariaapi.modelo.Usuario;
import br.com.alura.livrariaapi.dto.ItemLivroDto;
import br.com.alura.livrariaapi.dto.LivroDto;
import br.com.alura.livrariaapi.modelo.Autor;
import br.com.alura.livrariaapi.modelo.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query("select new br.com.alura.livrariaapi.dto.ItemLivroDto(b.nome, a.id, count(*) * 100.0 / (select count(*) from Livro)) from Livro a join \r\n"
			+ "a.autor b group by a.id, b.nome\r\n"
			+ "")
	
	
	List<ItemLivroDto> relatorioDeLivros();

	//Page<LivroDto> findAllByAutor(Pageable paginacao, Autor escritor);
	
	//Page<Livro> findAllByUsuario(Pageable paginacao, Usuario usuario);
	

	

}
