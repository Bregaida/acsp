/**
 * 
 */
package br.com.acsp.curso.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
