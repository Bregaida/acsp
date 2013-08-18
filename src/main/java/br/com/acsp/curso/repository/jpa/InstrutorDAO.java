/**
 *
 */
package br.com.acsp.curso.repository.jpa;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import br.com.acsp.curso.domain.Instrutor;
import br.com.acsp.curso.repository.InstrutorRepository;

/**
 * @author eduardobregaida
 */
@Repository
public class InstrutorDAO extends JpaGenericDAO<Instrutor, Long> implements InstrutorRepository {

    public InstrutorDAO() {
        super(Instrutor.class);
    }

	
	@Override
    public Collection<Instrutor> listarOrdenadoPorNome() {
        return em.createQuery("select a from Instrutor a order by a.nome").getResultList();
    }
}
