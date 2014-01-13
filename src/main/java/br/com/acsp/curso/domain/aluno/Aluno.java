/**
 *
 */
package br.com.acsp.curso.domain.aluno;

import br.com.acsp.curso.domain.piloto.Piloto;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author eduardobregaida
 */
@Document(collection = "pessoas")
@TypeAlias("ALUNO")
public class Aluno extends Piloto {
}
