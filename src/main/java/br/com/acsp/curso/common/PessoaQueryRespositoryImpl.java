package br.com.acsp.curso.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.query.Query.*;

/**
 * User: chrisreichel
 * Date: 13/01/2014
 * Time: 05:48
 */
public abstract class PessoaQueryRespositoryImpl<E, PK extends Serializable> implements PessoaQueryRespository<E, PK> {

    @Autowired
    private MongoOperations operations;

    private Class<? extends E> type;

    @Override
    public E findByCpf(String cpf) {
        final Query query = query(where("cpf").is(cpf));
        return operations.findOne(query, type);
    }

    @Override
    public Collection<E> findAllAtivos(){
        final Query query = query(where("ativo").is(true));
        return new ArrayList<>(operations.find(query, type));
    }

    @Override
    public void setType(Class<E> type) {
        this.type = type;
    }
}
