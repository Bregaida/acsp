/**
 *
 */
package br.com.acsp.curso.repository.jpa;

import br.com.acsp.curso.domain.Aula;
import br.com.acsp.curso.repository.AulaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author eduardobregaida
 */
@Repository
public class AulaDAO extends JpaGenericDAO<Aula, Long> implements
        AulaRepository {

    public AulaDAO() {
        super(Aula.class);
    }

    @Override
    public Collection<Aula> listarOrdenadoPorMateria() {
        return em.createQuery("select a from Aula a order by a.materia")
                .getResultList();
    }

}