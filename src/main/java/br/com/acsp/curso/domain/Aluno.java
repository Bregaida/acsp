/**
 *
 */
package br.com.acsp.curso.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author eduardobregaida
 */
@Entity
public class Aluno extends Pessoa {

    private static final long serialVersionUID = 6781271219397736009L;

    @Column
    private String nomePista;
    @Column
    private Long cma;
    @Column
    private Long cht;
    @Column
    private Long codigoANAC;

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
