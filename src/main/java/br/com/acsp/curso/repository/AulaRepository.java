/**
 *
 */
package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

/**
 * @author eduardobregaida
 */
public interface AulaRepository extends JpaRepository<Aula, Long> {

    @Query("select a from Aula a order by a.materia")
    Collection<Aula> listarOrdenadoPorMateria();
}
