/**
 *
 */
package br.com.acsp.curso.repository;

import java.util.Collection;

import br.com.acsp.curso.domain.Aeronave;

/**
 * @author eduardobregaida
 */
public interface AeronaveRepository extends GenericRepository<Aeronave, Long> {

	Collection<Aeronave> listarOrdenadoPorModelo();

}
