/**
 * 
 */
package br.com.acsp.curso.domain.clazz;

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
public class Aluno extends Pessoa {

	@Id
	@SequenceGenerator(name = "idSequenceAluno", sequenceName = "idSequenceAluno ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "idSequenceAluno", strategy = GenerationType.SEQUENCE)
	private Long id;
	private Long numeroMatricula;
	private String nomePista;
	private Long cma;
	private Long cht;
	private Long codigoANAC;

	public Long getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(Long numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

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
