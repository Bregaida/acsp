/**
 *
 */
package br.com.acsp.curso.domain;

import javax.persistence.Entity;

/**
 * @author eduardobregaida
 */
@Entity
public class Socio extends Pessoa {

	private static final long serialVersionUID = -4735921766760735482L;
	private Long numeroInscricao;

	public Long getNumeroInscricao() {
		return numeroInscricao;
	}

	public void setNumeroInscricao(Long numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
	}

}
