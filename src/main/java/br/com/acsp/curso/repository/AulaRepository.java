/**
 * 
 */
package br.com.acsp.curso.repository;

import java.util.Collection;

import br.com.acsp.curso.domain.Aula;

/**
 * @author eduardobregaida
 * 
 */
public interface AulaRepository extends GenericRepository<Aula, Long> {
	Collection<Aula> listarOrdenadoPorMateria();
}
