/**
 *
 */
package br.com.acsp.curso.domain;

import org.joda.time.LocalTime;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author eduardobregaida
 */
@Document
public class Horario extends AbstractDocument {

    private String horarioAgenda;

    private Set<Aeronave> aeronaves = new LinkedHashSet<>();

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
