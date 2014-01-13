/**
 *
 */
package br.com.acsp.curso.domain.horario;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author eduardobregaida
 */
public interface HorarioRepository extends MongoRepository<Horario, String> {
}