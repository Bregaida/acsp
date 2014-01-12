/**
 *
 */
package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Aeronave;
import br.com.acsp.curso.domain.Aula;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

/**
 * @author eduardobregaida
 */
public interface AulaRepository extends MongoRepository<Aula, String> {

    Collection<Aula> findByAeronaves(Aeronave aeronave);
}
