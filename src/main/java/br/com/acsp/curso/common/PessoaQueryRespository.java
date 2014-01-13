package br.com.acsp.curso.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.Collection;

/**
 * User: chrisreichel
 * Date: 13/01/2014
 * Time: 05:48
 */
public interface PessoaQueryRespository<E, PK extends Serializable> {

    /**
     * Retrieves an entity by the CPF
     * @param cpf
     * @return
     */
    E findByCpf(String cpf);

    Collection<E> findAllAtivos();

    void setType(Class<E> type);

}
