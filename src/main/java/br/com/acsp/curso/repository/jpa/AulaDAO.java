/**
 * 
 */
package br.com.acsp.curso.repository.jpa;

import br.com.acsp.curso.domain.Agenda;
import br.com.acsp.curso.domain.Aula;
import br.com.acsp.curso.repository.AgendaRepository;

/**
 * @author eduardobregaida
 * 
 */
public class AulaDAO extends JpaGenericDAO<Agenda, Long> implements
		AgendaRepository {

	public AulaDAO() {
		super(Aula.class);
	}

	/*
	 * @Override public Collection<Aula> listarOrdenadoPorMateria() { return
	 * em.createQuery
	 * ("select a from Aula a order by a.materia").getResultList(); }
	 */
}