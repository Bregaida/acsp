/**
 *
 */
package br.com.acsp.curso.domain.aluno;

import br.com.acsp.curso.common.AbstractPessoaService;
import br.com.acsp.curso.common.PessoaQueryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author eduardobregaida
 */

@Service
@Transactional
public class AlunoService extends AbstractPessoaService<Aluno, String> {

    @Autowired
    public void setRepository(AlunoRepository repository) {
        super.setRepository(repository);
    }

    @Autowired
    @Override
    public void setQueryRespository(PessoaQueryRespository<Aluno, String> pessoaQueryRespository) {
        super.setQueryRespository(pessoaQueryRespository);
        super.setType(Aluno.class);
    }
}
