/**
 *
 */
package br.com.acsp.curso.domain.atendente;

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
public class AtendenteService extends AbstractPessoaService<Atendente, String> {

    @Autowired
    public void setRepository(AtendenteRepository repository) {
        super.setRepository(repository);
    }

    @Autowired
    @Override
    public void setQueryRespository(PessoaQueryRespository<Atendente, String> pessoaQueryRespository) {
        super.setQueryRespository(pessoaQueryRespository);
        super.setType(Atendente.class);
    }
}
