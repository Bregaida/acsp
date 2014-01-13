/**
 *
 */
package br.com.acsp.curso.domain.socio;

import br.com.acsp.curso.common.AbstractPessoaService;
import br.com.acsp.curso.common.PessoaQueryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pedrosa
 */

@Service
public class SocioService extends AbstractPessoaService<Socio, String> {

    @Autowired
    public void setRepository(SocioRepository repository) {
        super.setRepository(repository);
    }

    @Autowired
    @Override
    public void setQueryRespository(PessoaQueryRespository<Socio, String> pessoaQueryRespository) {
        super.setQueryRespository(pessoaQueryRespository);
        super.setType(Socio.class);
    }
}
