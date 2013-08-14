/**
 * 
 */
package br.com.acsp.curso.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author eduardobregaida
 * 
 */
@Entity
public class Atendente extends Pessoa {

	@Id
	@SequenceGenerator(name = "idSequenceAtendente", sequenceName = "idSequenceAtendente ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "idSequenceAtendente", strategy = GenerationType.SEQUENCE)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
