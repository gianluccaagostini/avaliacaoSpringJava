package br.com.gianlucca.AvaliacaoSpring.model;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_contato")
public class Contato {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;
	
	@Column(nullable = false, length=1)
	private int tipoContato;
	
	@Column(nullable = false, length=200)
	private int contato;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "pessoa_id", referencedColumnName = "id")
	private Pessoa pessoa;
	
	public Contato() {}

	public Contato(Long id, int tipoContato, int contato, Pessoa pessoa) {
		this.id = id;
		this.tipoContato = tipoContato;
		this.contato = contato;
		this.pessoa = pessoa;
	}
	
	public void adicionarContato(int contato) {
		this.contato += contato;
	}
	
	public void removerContato(int contato) {
		this.contato -= contato;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(int tipoContato) {
		this.tipoContato = tipoContato;
	}

	public int getContato() {
		return contato;
	}

	public void setContato(int contato) {
		this.contato = contato;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
}
