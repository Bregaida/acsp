/**
 *
 */
package br.com.acsp.curso.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @author eduardobregaida
 */
@Entity
@DiscriminatorValue("INSTRUTOR_PILOTO")
public class Instrutor extends Piloto implements Serializable {

	private static final long serialVersionUID = -7104927923365640143L;

	@Column
	private Long quantidadeHorasMinistrada;

	public Long getQuantidadeHorasMinistrada() {
		return quantidadeHorasMinistrada;
	}

	public void setQuantidadeHorasMinistrada(Long quantidadeHorasMinistrada) {
		this.quantidadeHorasMinistrada = quantidadeHorasMinistrada;
	}

}
