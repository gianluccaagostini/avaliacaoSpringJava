package br.com.gianlucca.AvaliacaoSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gianlucca.AvaliacaoSpring.model.Contato;
import br.com.gianlucca.AvaliacaoSpring.model.Pessoa;
import br.com.gianlucca.AvaliacaoSpring.repository.ContatoRepository;
import br.com.gianlucca.AvaliacaoSpring.repository.PessoaRepository;

@Service
public class ContatoService {
	private ContatoRepository contatoRepository;
	private PessoaRepository pessoaRepository;
	
	@Autowired
	public ContatoService(ContatoRepository contatoRepository, PessoaRepository pessoaRepository) {
		this.contatoRepository = contatoRepository;
		this.pessoaRepository = pessoaRepository;
	}
	
	public Contato save(Long pessoaId, Contato contato) {
		Optional<Pessoa> getPessoa = pessoaRepository.findById(pessoaId);
		
		if(getPessoa.isPresent()) {
			Pessoa pessoa = getPessoa.get();
			contato.setPessoa(pessoa);
			return contatoRepository.save(contato);
		}
		return contato;
	}
	public Optional<Contato> getById(Long id) {
		return contatoRepository.findById(id);
	}
	
	public Optional<List<Contato>>getAll(Long pessoaId){
		
		Optional<Pessoa> getPessoa = pessoaRepository.findById(pessoaId);
		
		if(getPessoa.isPresent()) {
			Pessoa pessoa = getPessoa.get();
			return contatoRepository.findAllByPessoa(pessoa);
		}
		return null;
	}
	
	public Contato update(Long id, Contato contato) {
		Optional<Contato> attContato = contatoRepository.findById(id);
		
		if(attContato.isPresent()) {
			Contato newContato = attContato.get();
			newContato.setContato(contato.getContato());
			newContato.setTipoContato(contato.getTipoContato());
			return contatoRepository.save(newContato);
		}
		return contato;
	}
	
	public void delete(Long id) {
		contatoRepository.deleteById(id);
	}
	

	
	
}
