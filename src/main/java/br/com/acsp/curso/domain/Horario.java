/**
 * 
 */
package br.com.acsp.curso.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String horario;

	// @ManyToMany
	// @JoinTable(name = "agenda_aeronave", joinColumns = { @JoinColumn(name =
	// "horario_id") }, inverseJoinColumns = { @JoinColumn(name = "agenda_id")
	// })
	// private List<Agenda> agendas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	// public List<Agenda> getAgendas() {
	// return agendas;
	// }
	//
	// public void setAgendas(List<Agenda> agendas) {
	// this.agendas = agendas;
	// }

}
