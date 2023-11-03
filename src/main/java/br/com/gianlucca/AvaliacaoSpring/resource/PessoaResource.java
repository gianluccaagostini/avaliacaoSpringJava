package br.com.gianlucca.AvaliacaoSpring.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gianlucca.AvaliacaoSpring.dto.PessoaDTORecord;
import br.com.gianlucca.AvaliacaoSpring.model.Contato;
import br.com.gianlucca.AvaliacaoSpring.model.Pessoa;
import br.com.gianlucca.AvaliacaoSpring.service.ContatoService;
import br.com.gianlucca.AvaliacaoSpring.service.PessoaService;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaResource {
	
	private PessoaService pessoaService;
	private ContatoService contatoService;
	
	public PessoaResource(PessoaService pessoaService, ContatoService contatoService) {
		this.pessoaService = pessoaService;
		this.contatoService = contatoService;
	}
	@GetMapping("/maladireta/{id}")
	public Optional<PessoaDTORecord> getMalaDireta(@PathVariable Long id) {
		return pessoaService.getMalaDireta(id);
	}
	
	@GetMapping//ok
	public ResponseEntity<List<Pessoa>> getAllPessoas(){
		List<Pessoa> pessoas = pessoaService.getAll();
		if(pessoas ==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pessoas);
	}
	
	@GetMapping("/{id}")//ok
	public ResponseEntity<Optional<Pessoa>> getById(@PathVariable Long id){
		Optional<Pessoa> pessoa = pessoaService.getById(id);
		if(pessoa == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pessoa);
		
	}
	
	@PostMapping//ok
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
		Pessoa newPessoa = pessoaService.save(pessoa);
		
		if(newPessoa == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(newPessoa);
	}
	
	@PutMapping("/{id}")//verificar
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa, @PathVariable Long id) {
		Pessoa newPessoa = pessoaService.update(id, pessoa);
		
		if(newPessoa == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(newPessoa);
	}
	
	@DeleteMapping("/{id}")//ok
	public ResponseEntity<?> delete(@PathVariable Long id){
		pessoaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/{id}/contatos")
	public ResponseEntity<Contato>saveByIdContato(@PathVariable Long id, @RequestBody Contato contato){
		
		Contato newContato = contatoService.save(id, contato);
				
		if(newContato == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(newContato);
	}
	@GetMapping("/{idPessoa}/contatos")
	public ResponseEntity<Optional<List<Contato>>> findAll(@PathVariable Long idPessoa){
		Optional<List<Contato>> contatos = contatoService.getAll(idPessoa);
		if(contatos ==null ) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(contatos);
	}
	
	
	
}
