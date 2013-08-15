/**
 *
 */
package br.com.acsp.curso.repository.jpa;

import br.com.acsp.curso.domain.Socio;
import br.com.acsp.curso.repository.SocioRepository;
import org.springframework.stereotype.Repository;

/**
 * @author eduardobregaida
 */
@Repository
public class SocioDAO extends JpaGenericDAO<Socio, Long> implements SocioRepository {

    public SocioDAO() {
        super(Socio.class);
    }
}
