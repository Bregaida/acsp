/**
 * 
 */
package br.com.acsp.curso.domain.clazz;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author eduardobregaida
 * 
 */
@Entity
public class Aula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String materia;
	private Integer minimoHorasVoo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public Integer getMinimoHorasVoo() {
		return minimoHorasVoo;
	}

	public void setMinimoHorasVoo(Integer minimoHorasVoo) {
		this.minimoHorasVoo = minimoHorasVoo;
	}

}
