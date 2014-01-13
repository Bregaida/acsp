package br.com.acsp.curso.common;

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
     *
     * @param cpf
     * @return
     */
    E findByCpf(String cpf);

    Collection<E> findAllAtivos();

    Collection<E> findAll();

    void setType(Class<E> type);

}
