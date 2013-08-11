package br.com.acsp.curso.service;

import br.com.acsp.curso.repository.GenericRepository;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * User: Christian Reichel
 * Date: 8/11/13
 * Time: 10:45 PM
 */
abstract class AbstractService<E> {

    private final Logger LOGGER = LoggerFactory.getLogger(AbstractService.class);

    protected GenericRepository<E> repository;

    protected GenericRepository<E> getRepository(){
        return repository;
    }

    public void salvar(E entity) {
        System.out.println("merda ");
        LOGGER.info("Salvando service " + ToStringBuilder.reflectionToString(entity, ToStringStyle.MULTI_LINE_STYLE));
        getRepository().salva(entity);
    }

    public E alterar(E entity) {
        return getRepository().atualiza(entity);
    }

    public void excluir(E entity) {
        getRepository().exclui(entity);
    }

    public Collection<E> pesquisarTodos() {
        return getRepository().listarTodos();
    }
}
