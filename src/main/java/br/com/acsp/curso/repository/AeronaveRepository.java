/**
 *
 */
package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Aeronave;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

/**
 * @author eduardobregaida
 */
public interface AeronaveRepository extends MongoRepository<Aeronave, String> {

    Collection<Aeronave> findByAtivo(boolean status);
}
