package br.com.gianlucca.AvaliacaoSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gianlucca.AvaliacaoSpring.model.Contato;
import br.com.gianlucca.AvaliacaoSpring.model.Pessoa;
import br.com.gianlucca.AvaliacaoSpring.repository.ContatoRepository;
import br.com.gianlucca.AvaliacaoSpring.repository.PessoaRepository;
import br.com.gianlucca.AvaliacaoSpring.service.interfaces.ContatoServiceinterface;

@Service
public class ContatoService implements ContatoServiceinterface {
	private ContatoRepository contatoRepository;
	private PessoaRepository pessoaRepository;
	
	@Autowired
	public ContatoService(ContatoRepository contatoRepository, PessoaRepository pessoaRepository) {
		this.contatoRepository = contatoRepository;
		this.pessoaRepository = pessoaRepository;
	}
	
	public Contato save(Long pessoaId, Contato contato) {
		Optional<Pessoa> contatoPorPessoaId = this.pessoaRepository.findById(pessoaId);
		
		
		if(contatoPorPessoaId.isPresent()) {
			Pessoa pessoaporIdBuscado = contatoPorPessoaId.get();
			contato.setPessoa(pessoaporIdBuscado);
			return contatoRepository.save(contato);
		}
		return contato;
	}
	public Optional<Contato> getById(Long id) {
		return contatoRepository.findById(id);
	}
	
	public Optional<List<Contato>>getAll(Long pessoaId){
		
		Optional<Pessoa> listaPessoaId = pessoaRepository.findById(pessoaId);
		
		if(listaPessoaId.isPresent()) {
			Pessoa pessoa = listaPessoaId.get();
			return contatoRepository.findAllByPessoa(pessoa);
		}
		return null;
	}
	
	public Contato update(Long id, Contato contato) {
		Optional<Contato> updateContato = contatoRepository.findById(id);
		
		if(updateContato.isPresent()) {
			Contato contatoNovo = updateContato.get();
			contatoNovo.setContato(contato.getContato());
			contatoNovo.setTipoContato(contato.getTipoContato());
			return contatoRepository.save(contatoNovo);
		}
		return contato;
	}
	
	public void delete(Long id) {
		contatoRepository.deleteById(id);
	}
	

	
	
}
