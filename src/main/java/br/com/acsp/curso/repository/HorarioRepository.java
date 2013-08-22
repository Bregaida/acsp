/**
 * 
 */
package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

/**
 * @author eduardobregaida
 * 
 */
public interface HorarioRepository extends JpaRepository<Horario, Long> {

    @Query("select a from Horario a order by a.id")
	Collection<Horario> listarOrdenadoPorId();
}