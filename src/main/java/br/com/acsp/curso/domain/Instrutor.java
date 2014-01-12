/**
 *
 */
package br.com.acsp.curso.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author eduardobregaida
 */
@Document
public class Instrutor extends Piloto {

    private Long quantidadeHorasMinistrada;

    public Long getQuantidadeHorasMinistrada() {
        return quantidadeHorasMinistrada;
    }

    public void setQuantidadeHorasMinistrada(Long quantidadeHorasMinistrada) {
        this.quantidadeHorasMinistrada = quantidadeHorasMinistrada;
    }
}
