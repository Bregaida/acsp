/**
 * 
 */
package br.com.acsp.curso.domain;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author eduardobregaida
 * 
 */
@MappedSuperclass
public abstract class Pessoa implements Serializable {

	private String nome;
	private Long rg;
	private Long cpf;
	private Long tituloEleitor;
	private Long alistamentoMilitar;

	@Enumerated(EnumType.STRING)
	private EscolaridadeType escolaridade;
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

	public EscolaridadeType getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(EscolaridadeType escolaridade) {
		this.escolaridade = escolaridade;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
