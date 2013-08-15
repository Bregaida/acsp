/**
 *
 */
package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Aluno;

import java.util.Collection;

/**
 * @author eduardobregaida
 */
public interface AlunoRepository extends GenericRepository<Aluno, Long> {

    Collection<Aluno> listarOrdenadoPorNome();
}
