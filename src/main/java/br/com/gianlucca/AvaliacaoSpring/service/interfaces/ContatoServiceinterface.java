package br.com.gianlucca.AvaliacaoSpring.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.gianlucca.AvaliacaoSpring.model.Contato;
import br.com.gianlucca.AvaliacaoSpring.model.Pessoa;

public interface ContatoServiceinterface {
	/*Contato save(Contato contato);*/
	Contato save(Long pessoaId, Contato contato);
	Optional<Contato> getById(Long id);
	Optional<List<Contato>> getAll(Long pessoaId);
	Contato update(Long id, Contato contato);
	void delete(Long id);
	
	
	
}
