package br.com.alura.livrariaapi.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioFormDto {

	@NotBlank(message = "Deve ser informado!")
	private String nome;
	@NotBlank
	private String login;
	
	@NotNull
	private Long perfilId;
	
	@NotBlank
	@Email
	private String email;
	
}
