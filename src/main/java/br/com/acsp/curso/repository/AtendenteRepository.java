/**
 *
 */
package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Atendente;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

/**
 * @author eduardobregaida
 */
public interface AtendenteRepository extends MongoRepository<Atendente, String> {

    Collection<Atendente> findByAtivo(boolean status);
}
