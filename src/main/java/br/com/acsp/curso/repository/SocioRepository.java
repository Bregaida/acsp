/**
 *
 */
package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Socio;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

/**
 * @author eduardobregaida
 */
public interface SocioRepository extends MongoRepository<Socio, String> {

    Collection<Socio> findByAtivo(boolean status);
}
