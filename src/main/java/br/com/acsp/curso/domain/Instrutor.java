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
public class Instrutor extends Pessoa {

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
