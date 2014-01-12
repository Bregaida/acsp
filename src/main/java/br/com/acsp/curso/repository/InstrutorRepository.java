/**
 *
 */
package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Aeronave;
import br.com.acsp.curso.domain.Instrutor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

/**
 * @author eduardobregaida
 */
public interface InstrutorRepository extends MongoRepository<Instrutor, String> {

    Collection<Instrutor> findByAtivo(boolean status);

    Collection<Instrutor> findByAeronaves(Collection<Aeronave> aeronaves);
}
