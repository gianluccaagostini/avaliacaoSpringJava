package br.com.gianlucca.AvaliacaoSpring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gianlucca.AvaliacaoSpring.model.Contato;
import br.com.gianlucca.AvaliacaoSpring.model.Pessoa;

public interface ContatoRepository extends JpaRepository<Contato, Long>{
	Optional<List<Contato>> findAllByPessoa(Pessoa pessoa);
}
