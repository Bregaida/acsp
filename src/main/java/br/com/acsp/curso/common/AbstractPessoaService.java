package br.com.acsp.curso.common;

import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.Collection;

/**
 * User: chrisreichel
 * Date: 13/01/2014
 * Time: 06:50
 */
public abstract class AbstractPessoaService<E, PK extends Serializable> extends AbstractService<E, PK> {

    PessoaQueryRespository<E, PK> queryRespository;

    public Collection<E> listarOrdenado() {
        final Sort sort = new Sort(getSortAttribute());
        return getRepository().findAll(sort);
    }

    public E obtemPorCPF(String cpf) {
        return queryRespository.findByCpf(cpf);
    }

    @Override
    public String getSortAttribute() {
        return "nome";
    }

    public void setQueryRespository(PessoaQueryRespository<E, PK> pessoaQueryRespository) {
        this.queryRespository = pessoaQueryRespository;
    }

    public void setType(Class<E> type) {
        queryRespository.setType(type);
    }
}
