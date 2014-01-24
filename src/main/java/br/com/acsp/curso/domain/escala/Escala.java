/**
 * 
 */
package br.com.acsp.curso.domain.escala;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.acsp.curso.anotation.Reserva;
import br.com.acsp.curso.domain.instrutor.Instrutor;
import br.com.acsp.curso.util.CustomDateSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author eduardobregaida
 * 
 *         Escala de Vôos
 */

@Document
public class Escala {

    @JsonSerialize(using = CustomDateSerializer.class)
    @DateTimeFormat(style = "S-")
    @NotNull
    @Reserva
    private Date dataEscala;

    private List<Instrutor> instrutores;

    public Date getDataEscala() {
	return dataEscala;
    }

    public void setDataEscala(Date dataEscala) {
	this.dataEscala = dataEscala;
    }

    public List<Instrutor> getInstrutores() {
	return instrutores;
    }

    public void setInstrutores(List<Instrutor> instrutores) {
	this.instrutores = instrutores;
    }

}
