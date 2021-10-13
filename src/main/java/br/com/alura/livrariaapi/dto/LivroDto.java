package br.com.alura.livrariaapi.dto;

import java.time.LocalDate;

import br.com.alura.livrariaapi.modelo.Autor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroDto {

	private Long id;
	private String titulo;
	private LocalDate dataLancamento;
	private Integer numPaginas;
	private Autor autor;
}
