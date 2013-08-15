/**
 *
 */
package br.com.acsp.curso.repository.jpa;

import br.com.acsp.curso.domain.Aluno;
import br.com.acsp.curso.repository.AlunoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author eduardobregaida
 */
@Repository
public class AlunoDAO extends JpaGenericDAO<Aluno, Long> implements AlunoRepository {

    public AlunoDAO() {
        super(Aluno.class);
    }


    @Override
    public Collection<Aluno> listarOrdenadoPorNome() {
        return em.createQuery("select a from Aluno a order by a.nome").getResultList();
    }
}
