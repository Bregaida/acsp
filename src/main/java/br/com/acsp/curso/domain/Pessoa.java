/**
 *
 */
package br.com.acsp.curso.domain;

import br.com.acsp.curso.util.CustomEnumEscolaridadeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author eduardobregaida
 *         http://en.wikibooks.org/wiki/Java_Persistence/Inheritance
 */
@Document
public class Pessoa extends AbstractDocument {

    @NotBlank
    private String nome;

    @NotBlank
    private String rg;

    @CPF
    private String cpf;

    private Long tituloEleitor;

    private Long alistamentoMilitar;

    private boolean ativo;

    @JsonSerialize(using = CustomEnumEscolaridadeSerializer.class)
    private EscolaridadeType escolaridade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getTituloEleitor() {
        return tituloEleitor;
    }

    public void setTituloEleitor(Long tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }

    public Long getAlistamentoMilitar() {
        return alistamentoMilitar;
    }

    public void setAlistamentoMilitar(Long alistamentoMilitar) {
        this.alistamentoMilitar = alistamentoMilitar;
    }

    public EscolaridadeType getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(EscolaridadeType escolaridade) {
        this.escolaridade = escolaridade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
