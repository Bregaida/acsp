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

    @Query("select a from Instrutor a where a.ativo = 'Y' order by a.nome ")
    Collection<Instrutor> listarAtivos();

    // select p.nome
    // from Pessoa_Aeronave pa
    // left join Pessoa p on (p.id = pa.Pessoa_id)
    // left join Aeronave ae on (ae.id = pa.aeronaves_id)
    // left join Aula au on (p.quantidadeHorasMinistrada >=
    // au.quantidadeHorasNecessarias)
    // where p.PESSOA_TYPE='INSTRUTOR_PILOTO'
    // #and p.ativo = 'true'
    // and au.id = :aula
    // and ae.id= :aeronave;
    // Collection<Instrutor> listarInstrutoresPorAeronavePorAula();

    // select p.nome
    // from Pessoa_Aeronave pa
    // left join Pessoa p on (p.id = pa.Pessoa_id)
    // left join Aeronave ae on (ae.id = pa.aeronaves_id)
    // left join Aula au on (p.quantidadeHorasMinistrada >=
    // au.quantidadeHorasNecessarias)
    // where p.PESSOA_TYPE='INSTRUTOR_PILOTO'
    // #and p.ativo = 'true'
    // and ae.id= :aeronave;
    // Collection<Instrutor> listarInstrutoresPorAeronaveSemAula();
}
