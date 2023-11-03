package br.com.gianlucca.AvaliacaoSpring.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.gianlucca.AvaliacaoSpring.dto.PessoaDTORecord;
import br.com.gianlucca.AvaliacaoSpring.model.Contato;
import br.com.gianlucca.AvaliacaoSpring.model.Pessoa;

public interface PessoaServiceInterface {
	Pessoa save(Pessoa pessoa);
	Optional<Pessoa> getById(Long id);
	List<Pessoa> getAll();
	Pessoa update(Long id, Pessoa pessoa);
	void delete(Long id);
	Optional<PessoaDTORecord> getMalaDireta(Long id);
	//Optional<List<Contato>> findAllByPessoa(Pessoa pessoa);
}
