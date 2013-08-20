/**
 * 
 */
package br.com.acsp.curso.repository;

import java.util.Collection;

import br.com.acsp.curso.domain.Horario;

/**
 * @author eduardobregaida
 * 
 */
public interface HorarioRepository extends GenericRepository<Horario, Long> {
	Collection<Horario> listarOrdenadoPorId();
}