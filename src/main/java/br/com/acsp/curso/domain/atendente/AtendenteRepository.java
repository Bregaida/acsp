/**
 *
 */
package br.com.acsp.curso.domain.atendente;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author eduardobregaida
 */
public interface AtendenteRepository extends MongoRepository<Atendente, String> {
}
