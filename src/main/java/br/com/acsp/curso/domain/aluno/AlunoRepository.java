/**
 *
 */
package br.com.acsp.curso.domain.aluno;

import br.com.acsp.curso.common.PessoaQueryRespository;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author eduardobregaida
 */
public interface AlunoRepository extends MongoRepository<Aluno, String>, PessoaQueryRespository<Aluno, String> {

}
