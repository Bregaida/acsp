/**
 *
 */
package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Aeronave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Date;

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
