/**
 *
 */
package br.com.acsp.curso.domain.atendente;

import br.com.acsp.curso.domain.pessoa.Pessoa;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author eduardobregaida
 */
@Document(collection = "pessoas")
public class Atendente extends Pessoa {
}
