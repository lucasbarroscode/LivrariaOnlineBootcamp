package br.com.alura.livrariaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.livrariaapi.modelo.Autor;



public interface AutorRepository extends JpaRepository<Autor, Long> {



}
