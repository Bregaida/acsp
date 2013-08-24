/**
 * 
 */
package br.com.acsp.curso.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author eduardobregaida
 * 
 */
@Entity
public class Horario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String horarioAgenda;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHorarioAgenda() {
		return horarioAgenda;
	}

	public void setHorarioAgenda(String horarioAgenda) {
		this.horarioAgenda = horarioAgenda;
	}
	

}
