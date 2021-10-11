package br.com.alura.livrariaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.livrariaapi.modelo.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {



}
