package br.com.acsp.curso.repository;

import java.util.Collection;

/**
 * User: Christian Reichel
 * Date: 8/11/13
 * Time: 10:32 PM
 */
public interface GenericRepository<E> {

    void exclui(E entity);

    void salva(E entity);

    E procuraPorId(Long id);

    E atualiza(E entity);

    Collection<E> listarTodos();
}
