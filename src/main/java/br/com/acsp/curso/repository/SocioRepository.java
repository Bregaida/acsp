/**
 *
 */
package br.com.acsp.curso.repository;

import java.util.Collection;

import br.com.acsp.curso.domain.Socio;

/**
 * @author eduardobregaida
 */

public interface SocioRepository extends GenericRepository<Socio, Long> {
	 Collection<Socio> listarOrdenadoPorNome();
}
