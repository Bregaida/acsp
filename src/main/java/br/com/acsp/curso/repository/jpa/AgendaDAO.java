/**
 *
 */
package br.com.acsp.curso.repository.jpa;

import br.com.acsp.curso.domain.Agenda;
import br.com.acsp.curso.repository.AgendaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author pedrosa
 */
@Repository
public class AgendaDAO extends JpaGenericDAO<Agenda, Long> implements AgendaRepository {

    public AgendaDAO() {
        super(Agenda.class);
    }


    /*@Override
    public Collection<Aluno> listarOrdenadoPorNome() {
        return em.createQuery("select a from Aluno a order by a.nome").getResultList();
    }*/
}
