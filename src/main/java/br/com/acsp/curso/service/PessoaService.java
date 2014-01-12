package br.com.acsp.curso.service;

import br.com.acsp.curso.domain.Pessoa;
import br.com.acsp.curso.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Christian Reichel
 * Date: 8/30/13
 * Time: 9:25 PM
 */
@Service
public class PessoaService extends AbstractService<Pessoa, String> {

    @Autowired
    public void setRepository(PessoaRepository repository) {
        super.repository = repository;
    }

    public Pessoa obtemPorCPF(String cpf) {
        return ((PessoaRepository) repository).findByCpf(cpf);
    }

    @Override
    protected String getSortAttribute() {
        return "nome";
    }
}
