/**
 * 
 */
package br.com.acsp.curso.repository.jpa;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import br.com.acsp.curso.domain.Horario;
import br.com.acsp.curso.repository.HorarioRepository;

/**
 * @author eduardobregaida
 * 
 */
@Repository
public class HorarioDAO extends JpaGenericDAO<Horario, Long> implements
		HorarioRepository {

	public HorarioDAO() {
		super(Horario.class);
	}

	@Override
	public Collection<Horario> listarOrdenadoPorId() {
		return em.createQuery("select a from Aeronave a order by a.id")
				.getResultList();
	}
}