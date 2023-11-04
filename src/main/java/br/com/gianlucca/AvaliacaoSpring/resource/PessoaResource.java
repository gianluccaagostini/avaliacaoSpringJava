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
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaResource {
	
	private PessoaService pessoaService;
	private ContatoService contatoService;
	
	public PessoaResource(PessoaService pessoaService, ContatoService contatoService) {
		this.pessoaService = pessoaService;
		this.contatoService = contatoService;
	}
	/*----------------------------------------------------Endpoints de Pessoa-----------------------------------------------------------------------------------------*/
	@Operation(summary = "Cria uma nova pessoa na tabela")
	@PostMapping 
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
		Pessoa pessoaNova = pessoaService.save(pessoa);
		
		if(pessoaNova == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pessoaNova);
	}
	
	
	@Operation(summary = "Busca e retorna uma pessoa pelo seu ID")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Pessoa>> getById(@PathVariable Long id){
		Optional<Pessoa> pessoapeloId = pessoaService.getById(id);
		if(pessoapeloId == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pessoapeloId);
		
	}
	
	@Operation(summary = "Busca uma pessoa pelo ID e retorna uma string concatenando o endereço, utilizando um DTO/Record")
	@GetMapping("/maladireta/{id}")
	public Optional<PessoaDTORecord> buscarMalaDireta(@PathVariable Long id) {
		return pessoaService.getMalaDireta(id);
	}
	
	@Operation(summary = "Lista todas as pessoas cadastradas na tabela tb_pessoas")
	@GetMapping
	public ResponseEntity<List<Pessoa>> getAllPessoas(){
		List<Pessoa> listaPessoas = pessoaService.getAll();
		if(listaPessoas == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(listaPessoas);
	}
	
	@Operation(summary = "Atualiza a pessoa pelo id")
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa, @PathVariable Long id) {
		Pessoa pessoaNova = pessoaService.update(id, pessoa);
		
		if(pessoaNova == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(pessoaNova);
	}
	
	
	@Operation(summary = "Deleta a pessoa pelo id")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		pessoaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	/*----------------------------------------------------Endpoints de Pessoa relacionados com contato-----------------------------------------------------------------------------------------*/
	
	@Operation(summary = "Salva um novo contato pelo ID da pessoa")
	@PostMapping("/{id}/contatos")
	public ResponseEntity<Contato>saveByIdContato(@PathVariable Long id, @RequestBody Contato contato){
		Contato contatoNovo = this.contatoService.save(id, contato);
				
		if(contatoNovo == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(contatoNovo);
	}
	
	@Operation(summary = "Retorna todos os contatos atribuidos à uma pessoa")
	@GetMapping("/{idPessoa}/contatos")
	public ResponseEntity<Optional<List<Contato>>> findAll(@PathVariable Long idPessoa){
		Optional<List<Contato>> listaContatos = contatoService.getAll(idPessoa);
		if(listaContatos ==null ) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(listaContatos);
	}
	
	
	
}
