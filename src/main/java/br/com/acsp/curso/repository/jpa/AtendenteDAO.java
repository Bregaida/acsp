/**
 *
 */
package br.com.acsp.curso.repository.jpa;

import br.com.acsp.curso.domain.Atendente;
import br.com.acsp.curso.repository.AtendenteRepository;
import org.springframework.stereotype.Repository;

/**
 * @author eduardobregaida
 */
@Repository
public class AtendenteDAO extends JpaGenericDAO<Atendente, Long> implements AtendenteRepository {

    public AtendenteDAO() {
        super(Atendente.class);
    }

}
