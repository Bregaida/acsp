/**
 *
 */
package br.com.acsp.curso.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author eduardobregaida
 */
@Document
public class Aula extends AbstractDocument {

    @NotBlank
    private String materia;

    @NotNull
    private Long quantidadeHorasNecessarias;

    private List<Aeronave> aeronaves = new ArrayList<Aeronave>();

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
