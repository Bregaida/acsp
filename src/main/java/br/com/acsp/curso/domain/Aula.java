/**
 *
 */
package br.com.acsp.curso.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author eduardobregaida
 */

@Entity
public class Aula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String materia;

    @Column
    private Long quantidadeHorasNecessarias;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "aula_aeronave", joinColumns = { @JoinColumn(name = "aula_id") }, inverseJoinColumns = { @JoinColumn(name = "aeronave_id") })
    private List<Aeronave> aeronaves = new ArrayList<Aeronave>();

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

    public Long getQuantidadeHorasNecessarias() {
        return quantidadeHorasNecessarias;
    }

    public void setQuantidadeHorasNecessarias(Long quantidadeHorasNecessarias) {
        this.quantidadeHorasNecessarias = quantidadeHorasNecessarias;
    }

	public List<Aeronave> getAeronaves() {
		return aeronaves;
	}

	public void setAeronaves(List<Aeronave> aeronaves) {
		this.aeronaves = aeronaves;
	}

    

}
