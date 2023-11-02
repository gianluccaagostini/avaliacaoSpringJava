package br.com.gianlucca.AvaliacaoSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gianlucca.AvaliacaoSpring.model.Contato;
import br.com.gianlucca.AvaliacaoSpring.repository.ContatoRepository;

@Service
public class ContatoService {
	private ContatoRepository contatoRepository;
	
	@Autowired
	public ContatoService(ContatoRepository contatoRepository) {
		this.contatoRepository = contatoRepository;
	}
	
	public Contato save(Contato contato) {
		return contatoRepository.save(contato);
	}
	public Optional<Contato> getById(Long id) {
		return contatoRepository.findById(id);
	}
	
	public List<Contato> getAll(){
		return contatoRepository.findAll();
	}
	
	public Contato update(Contato contato) {
		Optional<Contato> attContato = contatoRepository.findById(contato.getId());
		
		if(attContato.isPresent()) {
			Contato newContato = attContato.get();
			newContato.setContato(contato.getContato());
			newContato.setContato(contato.getContato());
			newContato.setTipoContato(contato.getTipoContato());
			return contatoRepository.save(newContato);
		}
		return contato;
	}
	
	public void delete(Long id) {
		contatoRepository.deleteById(id);
	}
	
	/*public Contato adicionarContato(Long id, int contato) {
		return new 
	}*/
	
	
}
