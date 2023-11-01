package br.com.gianlucca.AvaliacaoSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gianlucca.AvaliacaoSpring.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
