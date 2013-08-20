package br.com.acsp.curso.service;

import br.com.acsp.curso.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;

/**
 * User: Christian Reichel
 * Date: 8/11/13
 * Time: 10:45 PM
 */
@Transactional(propagation = Propagation.REQUIRED)
abstract class AbstractService<E, PK extends Serializable> {

    private final Logger LOGGER = LoggerFactory.getLogger(AbstractService.class);

    protected JpaRepository<E, PK> repository;

    protected JpaRepository<E, PK> getRepository() {
        return repository;
    }

    public void salvar(E entity) {
        getRepository().saveAndFlush(entity);
    }

    public E alterar(E entity) {
        return getRepository().saveAndFlush(entity);
    }

    public E obtemPorId(PK primaryKey) {
        return getRepository().findOne(primaryKey);
    }

    public void excluirPorId(PK primaryKey) {
        E entity = getRepository().findOne(primaryKey);
        if(entity == null){
            throw new EntityNotFoundException();
        }
        getRepository().delete(primaryKey);
    }

    public Collection<E> pesquisarTodos() {
        return getRepository().findAll();
    }
}
