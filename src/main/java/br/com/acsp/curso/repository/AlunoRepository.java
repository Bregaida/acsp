/**
 *
 */
package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

/**
 * @author eduardobregaida
 */
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query("select a from Aluno a order by a.nome")
    Collection<Aluno> listarOrdenadoPorNome();

    @Query("select a from Aluno a where a.ativo <>" + "'N'"+ " order by a.nome ")
    Collection<Aluno> listarAtivos();
}
