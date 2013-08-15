package br.com.acsp.curso.service;

import br.com.acsp.curso.repository.GenericRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * User: Christian Reichel
 * Date: 8/11/13
 * Time: 10:45 PM
 */
@Transactional(propagation = Propagation.REQUIRED)
abstract class AbstractService<E, PK> {

    private final Logger LOGGER = LoggerFactory.getLogger(AbstractService.class);

    protected GenericRepository<E, PK> repository;

    protected GenericRepository<E, PK> getRepository() {
        return repository;
    }

    public void salvar(E entity) {
        getRepository().salva(entity);
    }

    public E alterar(E entity) {
        return getRepository().atualiza(entity);
    }

    public E obtemPorId(PK id) {
        return getRepository().procuraPorId(id);
    }

    public void excluirPorId(PK primaryKey) {
        getRepository().excluiPorPK(primaryKey);
    }

    public Collection<E> pesquisarTodos() {
        return getRepository().listarTodos();
    }
}
