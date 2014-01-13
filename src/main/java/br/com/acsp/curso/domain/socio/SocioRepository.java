/**
 *
 */
package br.com.acsp.curso.domain.socio;

import br.com.acsp.curso.common.PessoaQueryRespository;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author eduardobregaida
 */
public interface SocioRepository extends MongoRepository<Socio, String>, PessoaQueryRespository<Socio, String> {
}
