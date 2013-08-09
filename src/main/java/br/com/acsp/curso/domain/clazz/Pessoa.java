/**
 * 
 */
package br.com.acsp.curso.domain.clazz;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import br.com.acsp.curso.domain.enumerator.Escolaridade;

/**
 * @author eduardobregaida
 * 
 */

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// private Long id;

	private String nome;
	private Long rg;
	private Long cpf;
	private Long tituloEleitor;
	private Long alistamentoMilitar;
	// @Enumerated(EnumType.STRING)
	private Escolaridade escolaridade;
	private boolean ativo;

	// public Long getId() {
	// return id;
	// }
	//
	// public void setId(Long id) {
	// this.id = id;
	// }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getRg() {
		return rg;
	}

	public void setRg(Long rg) {
		this.rg = rg;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Long getTituloEleitor() {
		return tituloEleitor;
	}

	public void setTituloEleitor(Long tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}

	public Long getAlistamentoMilitar() {
		return alistamentoMilitar;
	}

	public void setAlistamentoMilitar(Long alistamentoMilitar) {
		this.alistamentoMilitar = alistamentoMilitar;
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
