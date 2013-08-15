/**
 * 
 */
package br.com.acsp.curso.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author pedrosa
 * 
 */

@Entity
public class Agenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Calendar dataReserva;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Calendar dataReserva) {
		this.dataReserva = dataReserva;
	}
	
	

}
