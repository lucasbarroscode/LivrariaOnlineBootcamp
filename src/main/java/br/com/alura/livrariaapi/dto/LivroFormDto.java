package br.com.alura.livrariaapi.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAlias;

import br.com.alura.livrariaapi.modelo.Autor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroFormDto {

	@NotBlank
	@Size(min = 10, message = "O Título deve ter no mínimo 10 caracteres")
	private String titulo;
	@PastOrPresent
	private LocalDate dataLancamento;
	@NotNull
	@Min(value = 100, message = "Idade Inválida!")
	private int numPaginas;
	
	@JsonAlias("autor_id")
	private Long autorId;
}
