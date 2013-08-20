/**
 *
 */
package br.com.acsp.curso.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author eduardobregaida
 */
@Entity
public class Socio extends Piloto {

	private static final long serialVersionUID = -4735921766760735482L;

	@Column
	private Long numeroInscricao;

	public Long getNumeroInscricao() {
		return numeroInscricao;
	}

	public void setNumeroInscricao(Long numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
	}

}
