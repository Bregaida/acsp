/**
 *
 */
package br.com.acsp.curso.repository.jpa;

import br.com.acsp.curso.domain.Instrutor;
import br.com.acsp.curso.repository.InstrutorRepository;
import org.springframework.stereotype.Repository;

/**
 * @author eduardobregaida
 */
@Repository
public class InstrutorDAO extends JpaGenericDAO<Instrutor, Long> implements InstrutorRepository {

    public InstrutorDAO() {
        super(Instrutor.class);
    }
}
