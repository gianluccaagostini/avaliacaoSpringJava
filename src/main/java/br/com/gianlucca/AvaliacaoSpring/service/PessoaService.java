package br.com.gianlucca.AvaliacaoSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	@Override
	public Optional<PessoaDTORecord> getMalaDireta(Long id) {
		Pessoa pessoaPorId = pessoaRepository.findById(id).get();
		String malaDireta = "Rua: " + pessoaPorId.getEndereco() + " - CEP: " + pessoaPorId.getCep() + " - Cidade/UF: " + pessoaPorId.getCidade() + "/" + pessoaPorId.getUf();
		PessoaDTORecord pessoaDto = new PessoaDTORecord(pessoaPorId.getId(),pessoaPorId.getNome(), malaDireta);
		
		return Optional.of(pessoaDto);
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
	public ResponseEntity<Object> update(Long id,Pessoa pessoa) {
		Optional<Pessoa> updatePessoa = pessoaRepository.findById(id);
		
		if(updatePessoa.isPresent()) {
		Pessoa pessoaNova = updatePessoa.get();
		pessoaNova.setNome(pessoa.getNome());
		pessoaNova.setEndereco(pessoa.getEndereco());
		pessoaNova.setCep(pessoa.getCep());
		pessoaNova.setCidade(pessoa.getCidade());
		pessoaNova.setUf(pessoa.getUf());
		return ResponseEntity.ok(pessoaNova);
		//return pessoaRepository.save(newPessoa);
		}
		return ResponseEntity.notFound().build();
	}
	@Override
	public void delete(Long id) {
		 pessoaRepository.deleteById(id);
	}
	
	
}
