/**
 *
 */
package br.com.acsp.curso.domain.socio;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author eduardobregaida
 */
public interface SocioRepository extends MongoRepository<Socio, String> {
}
