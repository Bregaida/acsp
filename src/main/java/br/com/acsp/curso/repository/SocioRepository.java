/**
 *
 */
package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

/**
 * @author eduardobregaida
 */

public interface SocioRepository extends JpaRepository<Socio, Long> {

    @Query("select a from Socio a order by a.nome")
    Collection<Socio> listarOrdenadoPorNome();

    @Query("select a from Socio a where a.ativo <>'N' order by a.nome ")
    Collection<Socio> listarAtivos();
}
