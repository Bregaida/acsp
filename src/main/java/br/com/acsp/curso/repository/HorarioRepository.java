/**
 *
 */
package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Horario;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author eduardobregaida
 */
public interface HorarioRepository extends MongoRepository<Horario, String> {
}