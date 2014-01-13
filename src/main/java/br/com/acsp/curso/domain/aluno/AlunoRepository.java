/**
 *
 */
package br.com.acsp.curso.domain.aluno;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author eduardobregaida
 */
public interface AlunoRepository extends MongoRepository<Aluno, String> {

}
