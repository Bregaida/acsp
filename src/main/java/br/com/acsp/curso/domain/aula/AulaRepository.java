/**
 *
 */
package br.com.acsp.curso.domain.aula;

import br.com.acsp.curso.domain.aeronave.Aeronave;
import br.com.acsp.curso.domain.aula.Aula;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

/**
 * @author eduardobregaida
 */
public interface AulaRepository extends MongoRepository<Aula, String> {

    Collection<Aula> findByAeronaves(Aeronave aeronave);
}
