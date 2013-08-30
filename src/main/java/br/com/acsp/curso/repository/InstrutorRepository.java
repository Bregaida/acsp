/**
 *
 */
package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

/**
 * @author eduardobregaida
 */
public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {

	@Query("select a from Instrutor a order by a.nome")
	Collection<Instrutor> listarOrdenadoPorNome();

	// TODO: criar os joins
	@Query("select a from Instrutor a")
	Collection<Instrutor> listarInstrutoresDisponiveisPorHoraAeronaveAula(
			Long horaId, Long aeronaveId, Long aulaId);

}
