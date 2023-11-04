package br.com.gianlucca.AvaliacaoSpring.resource;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gianlucca.AvaliacaoSpring.model.Contato;
import br.com.gianlucca.AvaliacaoSpring.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/contatos")
public class ContatoResource {
	private ContatoService contatoService;
	
	@Autowired
	public ContatoResource(ContatoService contatoService) {
		this.contatoService = contatoService;
	}
	/*-------------------------------------------------------------------Endpoints de pessoas------------------------------------------------------------------------------*/
	@Operation(summary = "Busca o contato pelo Id do contato")
	@GetMapping("/{id}")//validado
	public ResponseEntity<Optional<Contato>> getById(@PathVariable Long id){
		Optional<Contato> contato = contatoService.getById(id);
		if(contato == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(contato);
	}
	
	@Operation(summary = "Atualiza o contato pelo id do contato")
	@PutMapping("/{id}")//validado
	public ResponseEntity<Contato> update(@RequestBody Contato contato,@PathVariable Long id){
		
		return new ResponseEntity<>(contatoService.update(id, contato), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Deleta o contato pelo id do contato")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		contatoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
