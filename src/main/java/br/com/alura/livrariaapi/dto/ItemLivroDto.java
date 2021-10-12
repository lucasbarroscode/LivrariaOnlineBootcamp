package br.com.alura.livrariaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemLivroDto {

	private String nome;
	private Long autor_id;
	private Double percentual;
	
}
