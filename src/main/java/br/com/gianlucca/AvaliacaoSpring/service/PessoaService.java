package br.com.gianlucca.AvaliacaoSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gianlucca.AvaliacaoSpring.dto.PessoaDTORecord;
import br.com.gianlucca.AvaliacaoSpring.model.Pessoa;
import br.com.gianlucca.AvaliacaoSpring.repository.PessoaRepository;
import br.com.gianlucca.AvaliacaoSpring.service.interfaces.PessoaServiceInterface;

@Service
public class PessoaService implements PessoaServiceInterface {

	private PessoaRepository pessoaRepository;
	
	@Autowired
	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	//Implementado agr
	@Override
	public Optional<PessoaDTORecord> getMalaDireta(Long id) {
		Pessoa pessoa = pessoaRepository.findById(id).get();
		String malaDireta = pessoa.getEndereco() + " - " + pessoa.getCep() + " - " + pessoa.getCidade() + "/" + pessoa.getUf();
		PessoaDTORecord dto = new PessoaDTORecord(pessoa.getId(),pessoa.getNome(), malaDireta);
		
		return Optional.of(dto);
	}
	
	@Override
	public Pessoa save(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	@Override
	public Optional<Pessoa> getById(Long id){
		return pessoaRepository.findById(id);
	}
	@Override
	public List<Pessoa> getAll() {
		return pessoaRepository.findAll();
	}
	@Override
	public Pessoa update(Long id,Pessoa pessoa) {
		Optional<Pessoa> attPessoa = pessoaRepository.findById(id);
		
		if(attPessoa.isPresent()) {
		Pessoa newPessoa = attPessoa.get();
		newPessoa.setNome(pessoa.getNome());
		newPessoa.setEndereco(pessoa.getEndereco());
		newPessoa.setCep(pessoa.getCep());
		newPessoa.setCidade(pessoa.getCidade());
		newPessoa.setUf(pessoa.getUf());
		return pessoaRepository.save(newPessoa);
		}
		return pessoa;
	}
	@Override
	public void delete(Long id) {
		pessoaRepository.deleteById(id);
	}
	
	
}
