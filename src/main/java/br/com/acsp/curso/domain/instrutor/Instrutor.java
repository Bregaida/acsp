/**
 *
 */
package br.com.acsp.curso.domain.instrutor;

import br.com.acsp.curso.domain.piloto.Piloto;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author eduardobregaida
 */
@Document(collection = "pessoas")
@TypeAlias("INSTRUTOR")
public class Instrutor extends Piloto {

    private Long quantidadeHorasMinistrada;

    public Long getQuantidadeHorasMinistrada() {
        return quantidadeHorasMinistrada;
    }

    public void setQuantidadeHorasMinistrada(Long quantidadeHorasMinistrada) {
        this.quantidadeHorasMinistrada = quantidadeHorasMinistrada;
    }
}
