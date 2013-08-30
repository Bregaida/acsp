/**
 * 
 */
package br.com.acsp.curso.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author eduardobregaida
 * 
 */
@MappedSuperclass
@DiscriminatorValue("PILOTO")
public abstract class Piloto extends Pessoa {

	private static final long serialVersionUID = -6447976014511027605L;
	@Column
	private String nomePista;
	@Column
	private Long cma;
	@Column
	private Long cht;
	@Column
	private Long codigoANAC;
	@OneToMany
	private List<Aeronave> aeronaves;

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

	public List<Aeronave> getAeronaves() {
		return aeronaves;
	}

	public void setAeronaves(List<Aeronave> aeronaves) {
		this.aeronaves = aeronaves;
	}

}
