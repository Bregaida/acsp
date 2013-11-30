/**
 *
 */
package br.com.acsp.curso.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @author eduardobregaida
 */
@Entity
@DiscriminatorValue("SOCIO_PILOTO")
public class Socio extends Piloto {

	@NotNull( message = "Número de inscrição não pode ser vazio" )
	@Column
	private Long numeroInscricao;

	public Long getNumeroInscricao() {
		return numeroInscricao;
	}

	public void setNumeroInscricao(Long numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
	}

}
