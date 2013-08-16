/**
 *
 */
package br.com.acsp.curso.repository.jpa;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import br.com.acsp.curso.domain.Aeronave;
import br.com.acsp.curso.repository.AeronaveRepository;

/**
 * @author eduardobregaida
 */

@Repository
public class AeronaveDAO extends JpaGenericDAO<Aeronave, Long> implements
		AeronaveRepository {

	public AeronaveDAO() {
		super(Aeronave.class);
	}

	@Override
	public Collection<Aeronave> listarOrdenadoPorModelo() {
		return em.createQuery("select a from Aeronave a order by a.modelo")
				.getResultList();
	}
}
