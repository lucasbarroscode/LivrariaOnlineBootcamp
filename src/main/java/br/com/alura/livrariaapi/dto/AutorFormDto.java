package br.com.alura.livrariaapi.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorFormDto {

	@NotNull
	private String nome;
	@NotNull
	@Email(message = "Email should be valid")
	private String email;
	
	@PastOrPresent
	private LocalDate data;
	@NotNull
	private String miniCV;
	
	
}
