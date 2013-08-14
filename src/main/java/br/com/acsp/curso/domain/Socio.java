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
public class Socio extends Pessoa {

	@Id
	@SequenceGenerator(name = "idSequenceSocio", sequenceName = "idSequenceSocio ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "idSequenceSocio", strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nomePista;
	private Long cma;
	private Long cht;
	private Long codigoANAC;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePista() {
		return nomePista;
	}

	public void setNomePista(String nomePista) {
		this.nomePista = nomePista;
	}

	public Long getCma() {
		return cma;
	}

	public void setCma(Long cma) {
		this.cma = cma;
	}

	public Long getCht() {
		return cht;
	}

	public void setCht(Long cht) {
		this.cht = cht;
	}

	public Long getCodigoANAC() {
		return codigoANAC;
	}

	public void setCodigoANAC(Long codigoANAC) {
		this.codigoANAC = codigoANAC;
	}

}
