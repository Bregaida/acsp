/**
 *
 */
package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Aeronave;
import br.com.acsp.curso.domain.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

/**
 * @author eduardobregaida
 */
public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {

    @Query("select a from Instrutor a order by a.nome")
    Collection<Instrutor> listarOrdenadoPorNome();

    @Query("select a from Instrutor a where a.ativo = 'Y' order by a.nome ")
    Collection<Instrutor> listarAtivos();

    @Query("select i from Instrutor i join i.aeronaves as aeronave where aeronave = ?1 and i.ativo = 'Y' order by i.nome")
    Collection<Instrutor> listarPorAeronave(Aeronave aeronave);

}
