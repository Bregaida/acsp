/**
 * 
 */
package br.com.acsp.curso.repository.jpa;

import org.springframework.stereotype.Repository;

import br.com.acsp.curso.domain.Agenda;
import br.com.acsp.curso.repository.AgendaRepository;

/**
 * @author pedrosa
 *
 */
@Repository
public class AgendaDAO extends JpaGenericDAO<Agenda, Long> implements AgendaRepository {

    public AgendaDAO(){
        super(Agenda.class);
    }


    /*@Override
    public Collection<Aluno> listarOrdenadoPorNome() {
        return em.createQuery("select a from Aluno a order by a.nome").getResultList();
    }*/
}
