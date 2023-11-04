package br.com.gianlucca.AvaliacaoSpring.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.gianlucca.AvaliacaoSpring.model.Contato;

public interface ContatoServiceinterface {
	Contato save(Long pessoaId, Contato contato);
	Optional<Contato> getById(Long id);
	Optional<List<Contato>> getAll(Long pessoaId);
	Contato update(Long id, Contato contato);
	void delete(Long id);
	
	
	
}
