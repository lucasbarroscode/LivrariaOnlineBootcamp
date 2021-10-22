package br.com.alura.livrariaapi.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorFormDto {

	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	private String email;
	
	@PastOrPresent
	private LocalDate data;
	
	@NotBlank
	private String miniCV;
	
	
}
