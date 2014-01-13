/**
 *
 */
package br.com.acsp.curso.domain.aluno;

import br.com.acsp.curso.domain.piloto.Piloto;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author eduardobregaida
 */
@Document(collection = "pessoas")
public class Aluno extends Piloto {
}
