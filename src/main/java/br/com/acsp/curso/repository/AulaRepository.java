/**
 *
 */
package br.com.acsp.curso.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.acsp.curso.domain.Aula;

/**
 * @author eduardobregaida
 */
public interface AulaRepository extends JpaRepository<Aula, Long> {

    @Query("select a from Aula a order by a.materia")
    Collection<Aula> listarOrdenadoPorMateria();

    // select au.materia, ae.id from aula_aeronave aa left join Aula au on
    // (au.id = aa.aula_id) left join Aeronave ae on (ae.id = aa.aeronave_id)
    // where ae.id= :aeronaveId;
    Collection<Aula> listarAulasPorAeronave();
}
