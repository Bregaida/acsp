/**
 *
 */
package br.com.acsp.curso.repository.jpa;

import br.com.acsp.curso.domain.Aeronave;
import br.com.acsp.curso.repository.AeronaveRepository;
import org.springframework.stereotype.Repository;

/**
 * @author eduardobregaida
 */

@Repository
public class AeronaveDAO extends JpaGenericDAO<Aeronave, Long> implements AeronaveRepository {

    public AeronaveDAO() {
        super(Aeronave.class);
    }
}
