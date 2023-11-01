package br.com.gianlucca.AvaliacaoSpring.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.gianlucca.AvaliacaoSpring.model.Contato;
import br.com.gianlucca.AvaliacaoSpring.model.Pessoa;

public interface ContatoServiceinterface {
	Contato save(Pessoa pessoa);
	Optional<Contato> getById(Long id);
	List<Contato> getAll(Pessoa pessoa);
	Contato update(Contato contato);
	void delete(Long id);
	/*Contato adicionarContato(Long id, int contato);
	Contato removerContato(Long id, int contato);*/
}