package br.com.acsp.curso.domain.pessoa;

import br.com.acsp.curso.common.AbstractPessoaService;
import br.com.acsp.curso.common.PessoaQueryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Christian Reichel
 * Date: 8/30/13
 * Time: 9:25 PM
 */
@Service
public class PessoaService extends AbstractPessoaService<Pessoa, String> {

    @Autowired
    @Override
    public void setQueryRespository(PessoaQueryRespository<Pessoa, String> pessoaQueryRespository) {
        super.setQueryRespository(pessoaQueryRespository);
        super.setType(Pessoa.class);
    }

}
