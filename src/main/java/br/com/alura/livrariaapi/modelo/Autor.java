package br.com.alura.livrariaapi.modelo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

	private String nome;
	private String email;
	private LocalDate data;
	private String miniCV;
	

}
