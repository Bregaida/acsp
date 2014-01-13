/**
 *
 */
package br.com.acsp.curso.domain.atendente;

import br.com.acsp.curso.common.PessoaQueryRespository;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author eduardobregaida
 */
public interface AtendenteRepository extends MongoRepository<Atendente, String>, PessoaQueryRespository<Atendente, String> {
}
