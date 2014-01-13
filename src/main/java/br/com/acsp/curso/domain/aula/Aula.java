/**
 *
 */
package br.com.acsp.curso.domain.aula;

import br.com.acsp.curso.common.AbstractDocument;
import br.com.acsp.curso.domain.aeronave.Aeronave;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.DBRef;
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

    @DBRef
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
