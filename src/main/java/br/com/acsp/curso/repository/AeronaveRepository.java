/**
 *
 */
package br.com.acsp.curso.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.acsp.curso.domain.Aeronave;

/**
 * @author eduardobregaida
 */
public interface AeronaveRepository extends JpaRepository<Aeronave, Long> {

    @Query("select a from Aeronave a order by a.modelo")
    Collection<Aeronave> listarOrdenadoPorModelo();

    @Query("select a from Aeronave a where a.ativo <>" + "'N'"
	    + " order by a.modelo ")
    Collection<Aeronave> listarAtivas();

    // @Query("select ae.marca, ae.modelo, ae.certificadoMatricula from Pessoa_Aeronave pa left join Pessoa p on (p.id = pa.Pessoa_id) left join Aeronave ae on (ae.id = pa.aeronaves_id) where p.PESSOA_TYPE='ALUNO_PILOTO' and ae.ativo = 'true' and p.id= :aluno ")
    // Collection<Aeronave> listarAeronavesAtivasPorAluno(Long id);
}
