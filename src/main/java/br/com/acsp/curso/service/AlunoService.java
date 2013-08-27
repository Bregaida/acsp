/**
 *
 */
package br.com.acsp.curso.service;

import br.com.acsp.curso.domain.Aeronave;
import br.com.acsp.curso.domain.Aluno;
import br.com.acsp.curso.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * @author eduardobregaida
 */

@Service
@Transactional
public class AlunoService extends AbstractService<Aluno, Long> {

    @Autowired
    public void setRepository(AlunoRepository repository) {
        super.repository = repository;
    }

    public Collection<Aluno> listarOrdenado() {
        return ((AlunoRepository) repository).listarOrdenadoPorNome();
    }

    public Aluno getByIdDetached(Long id) {
        Aluno aluno = repository.findOne(id);

        //FIXME just to load the list for now
        List<Aeronave> aeronaves = aluno.getAeronaves();
        for (Aeronave aeronave : aeronaves) {
            aeronave.isAtivo();
        }

        return aluno;
    }
}
