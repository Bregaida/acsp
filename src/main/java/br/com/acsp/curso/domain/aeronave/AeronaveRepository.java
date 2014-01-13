/**
 *
 */
package br.com.acsp.curso.domain.aeronave;

import br.com.acsp.curso.domain.aeronave.Aeronave;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

/**
 * @author eduardobregaida
 */
public interface AeronaveRepository extends MongoRepository<Aeronave, String> {

    Collection<Aeronave> findByAtivo(boolean status);
}
