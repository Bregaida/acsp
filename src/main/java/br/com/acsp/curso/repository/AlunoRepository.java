/**
 *
 */
package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

/**
 * @author eduardobregaida
 */
public interface AlunoRepository extends MongoRepository<Aluno, String> {

    Collection<Aluno> findByAtivo(boolean status);
}
