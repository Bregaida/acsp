package br.com.acsp.curso.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * User: chrisreichel
 * Date: 13/01/2014
 * Time: 05:48
 */
@Repository
@Scope("prototype")
public class PessoaQueryRespositoryImpl<E, PK extends Serializable> implements PessoaQueryRespository<E, PK> {

    @Autowired
    private MongoOperations operations;

    private Class<? extends E> type;

    @Override
    public E findByCpf(String cpf) {
        final Query query = query(where("cpf").is(cpf));
        return operations.findOne(query, type);
    }

    @Override
    public Collection<E> findAllAtivos() {
        final Query query = query(where("ativo").is(true)).addCriteria(getTypeCriteria());
        return new ArrayList<>(operations.find(query, type));
    }

    @Override
    public Collection<E> findAll() {
        final Query query = query(getTypeCriteria());
        return new ArrayList<>(operations.find(query, type));
    }

    Criteria getTypeCriteria() {
        final String _class = this.type.getName();
        final Criteria typeCriteria = where("_class").is(_class);
        return typeCriteria;
    }

    @Override
    public void setType(Class<E> type) {
        this.type = type;
    }
}
