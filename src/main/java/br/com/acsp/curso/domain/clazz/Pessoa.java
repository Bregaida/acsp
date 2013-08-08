/**
 * 
 */
package br.com.acsp.curso.domain.clazz;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.acsp.curso.domain.enumerator.Escolaridade;

/**
 * @author eduardobregaida
 * 
 */
public abstract class Pessoa {

	private String nome;
	private Long rg;
	private Long cpf;
	private Long tituloEleitor;
	private Long alistamentoMilitar;
	@Enumerated(EnumType.STRING)
	private Escolaridade escolaridade;
	private boolean ativo;

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
