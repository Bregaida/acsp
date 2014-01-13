/**
 *
 */
package br.com.acsp.curso.domain.piloto;

import br.com.acsp.curso.domain.pessoa.Pessoa;
import br.com.acsp.curso.domain.aeronave.Aeronave;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author eduardobregaida
 */
@Document(collection = "pessoas")
@TypeAlias("PILOTO")
public abstract class Piloto extends Pessoa {

    private String nomePista;
    private Long cma;
    private Long cht;
    private Long codigoANAC;
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
