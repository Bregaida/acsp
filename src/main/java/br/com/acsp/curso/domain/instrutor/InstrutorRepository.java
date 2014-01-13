/**
 *
 */
package br.com.acsp.curso.domain.instrutor;

import br.com.acsp.curso.common.PessoaQueryRespository;
import br.com.acsp.curso.domain.aeronave.Aeronave;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

/**
 * @author eduardobregaida
 */
public interface InstrutorRepository extends MongoRepository<Instrutor, String>, PessoaQueryRespository<Instrutor, String> {

    Collection<Instrutor> findByAeronaves(Collection<Aeronave> aeronaves);
}
