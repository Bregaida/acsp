/**
 *
 */
package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Aula;

import java.util.Collection;

/**
 * @author eduardobregaida
 */
public interface AulaRepository extends GenericRepository<Aula, Long> {
    Collection<Aula> listarOrdenadoPorMateria();
}
