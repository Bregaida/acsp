/**
 *
 */
package br.com.acsp.curso.repository;

import java.util.Collection;

import br.com.acsp.curso.domain.Aeronave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.acsp.curso.domain.Aula;

/**
 * @author eduardobregaida
 */
public interface AulaRepository extends JpaRepository<Aula, Long> {

    @Query("select a from Aula a order by a.materia")
    Collection<Aula> listarOrdenadoPorMateria();

    Collection<Aula> findByAeronaves(Aeronave aeronave);
}
