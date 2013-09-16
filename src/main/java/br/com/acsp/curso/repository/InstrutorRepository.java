/**
 *
 */
package br.com.acsp.curso.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.acsp.curso.domain.Instrutor;

/**
 * @author eduardobregaida
 */
public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {

	@Query("select a from Instrutor a order by a.nome")
	Collection<Instrutor> listarOrdenadoPorNome();

    @Query("select a from Instrutor a where a.ativo <> 'N' order by a.nome ")
    Collection<Instrutor> listarAtivos();
}
