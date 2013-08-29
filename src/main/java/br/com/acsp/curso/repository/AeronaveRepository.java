/**
 *
 */
package br.com.acsp.curso.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.acsp.curso.domain.Aeronave;

/**
 * @author eduardobregaida
 */
public interface AeronaveRepository extends JpaRepository<Aeronave, Long> {

	@Query("select a from Aeronave a order by a.modelo")
	Collection<Aeronave> listarOrdenadoPorModelo();

	// TODO: criar os joins
	@Query("select a from Aeronave a")
	Collection<Aeronave> listarAeronavesDisponiveis(Date dataReserva);

}
