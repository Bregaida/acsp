/**
 *
 */
package br.com.acsp.curso.domain.socio;

import br.com.acsp.curso.domain.piloto.Piloto;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

/**
 * @author eduardobregaida
 */
@Document(collection = "pessoas")
public class Socio extends Piloto {

    @NotNull(message = "Número de inscrição não pode ser vazio")
    private Long numeroInscricao;

    public Long getNumeroInscricao() {
        return numeroInscricao;
    }

    public void setNumeroInscricao(Long numeroInscricao) {
        this.numeroInscricao = numeroInscricao;
    }

}
