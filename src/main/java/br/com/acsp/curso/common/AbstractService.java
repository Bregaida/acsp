package br.com.acsp.curso.common;

import br.com.acsp.curso.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;
import java.util.Collection;

/**
 * User: Christian Reichel
 * Date: 8/11/13
 * Time: 10:45 PM
 */
public abstract class AbstractService<E, PK extends Serializable> {

    private final Logger LOGGER = LoggerFactory.getLogger(AbstractService.class);

    private MongoRepository<E, PK> repository;

    public MongoRepository<E, PK> getRepository() {
        return repository;
    }

    public void setRepository(MongoRepository<E, PK> repository) {
        this.repository = repository;
    }

    public void salvar(E entity) {
        getRepository().save(entity);
    }

    public E alterar(E entity) {
        return getRepository().save(entity);
    }

    public E obtemPorId(PK primaryKey) {
        return getRepository().findOne(primaryKey);
    }

    public void excluirPorId(PK primaryKey) {
        E entity = getRepository().findOne(primaryKey);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        getRepository().delete(primaryKey);
    }

    public Collection<E> pesquisarTodos() {
        return getRepository().findAll();
    }

    public Page<E> pesquisarTodos(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    public Collection<E> listarOrdenado() {
        final Sort sort = new Sort(Sort.Direction.ASC, getSortAttribute());
        return getRepository().findAll(sort);
    }

    public abstract String getSortAttribute();
}
