package br.com.alura.livrariaapi.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//tb_gestao == new tb_livros
@Table(name = "livros")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private LocalDate dataLancamento;
	private Integer numPaginas;
	
	@ManyToOne
	private Autor autor;
	
//	@ManyToOne
//	private Usuario usuario;
	

	public Livro(String titulo, LocalDate dataLancamento, Integer numPaginas, Autor autor) {
		
		this.titulo = titulo;
		this.dataLancamento = dataLancamento;
		this.numPaginas = numPaginas;
		this.autor = autor;
	}

	public void atualizarInformacoes(String titulo, LocalDate dataLancamento, int numPaginas) {
		this.titulo = titulo;
		this.dataLancamento = dataLancamento;
		this.numPaginas = numPaginas;
		
		
	}

	public boolean pertenceAoAutor(Autor autor) {
		return this.autor.equals(autor);
	}
	
	
	
	
}
