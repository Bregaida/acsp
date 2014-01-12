package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Pessoa;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * User: Christian Reichel
 * Date: 8/30/13
 * Time: 9:27 PM
 */
public interface PessoaRepository extends MongoRepository<Pessoa, String> {

    public Pessoa findByCpf(String cpf);
}
