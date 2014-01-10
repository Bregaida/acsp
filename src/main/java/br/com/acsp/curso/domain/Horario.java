/**
 * 
 */
package br.com.acsp.curso.domain;

import org.joda.time.LocalTime;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author eduardobregaida
 * 
 */
@Entity
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String horarioAgenda;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "horario_aeronave", joinColumns = { @JoinColumn(name = "horario_id") }, inverseJoinColumns = { @JoinColumn(name = "aeronave_id") })
    private Set<Aeronave> aeronaves = new LinkedHashSet<>();

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

    public int getTranslatedHourToInt() {
	return LocalTime.parse(horarioAgenda).getHourOfDay();
    }

    public Set<Aeronave> getAeronaves() {
	return aeronaves;
    }

    public void setAeronaves(Set<Aeronave> aeronaves) {
	this.aeronaves = aeronaves;
    }

}
