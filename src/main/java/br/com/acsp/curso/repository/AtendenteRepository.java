/**
 *
 */
package br.com.acsp.curso.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.acsp.curso.domain.Atendente;

/**
 * @author eduardobregaida
 */
public interface AtendenteRepository extends JpaRepository<Atendente, Long> {

	@Query("select a from Atendente a order by a.nome")
	Collection<Atendente> listarOrdenadoPorNome();
}
