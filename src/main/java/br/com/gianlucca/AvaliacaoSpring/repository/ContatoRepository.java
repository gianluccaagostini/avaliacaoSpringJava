package br.com.gianlucca.AvaliacaoSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gianlucca.AvaliacaoSpring.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
