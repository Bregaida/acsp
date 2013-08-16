/**
 *
 */
package br.com.acsp.curso.repository.jpa;

import java.util.Collection;

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

	@Override
	public Collection<Socio> listarOrdenadoPorNome() {
		return em.createQuery("select a from Socio a order by a.nome").getResultList();
	}
}
