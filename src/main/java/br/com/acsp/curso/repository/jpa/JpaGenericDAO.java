package br.com.acsp.curso.repository.jpa;

import br.com.acsp.curso.repository.GenericRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * User: Christian Reichel
 * Date: 8/11/13
 * Time: 10:24 PM
 */
public abstract class JpaGenericDAO<E, PK> implements GenericRepository<E, PK> {

    private final Logger LOGGER = LoggerFactory.getLogger(JpaGenericDAO.class);

    @PersistenceContext
    protected EntityManager em;

    private Class clazz;

    public JpaGenericDAO(Class clazz) {
        LOGGER.info("Pertence a " + clazz);
        this.clazz = clazz;
    }

    @Override
    public void excluiPorPK(PK primaryKey) {
        final E entity = (E) em.find(clazz, primaryKey);
        em.remove(entity);
        em.flush();
    }

    @Override
    public void salva(E entity) {
        em.persist(entity);
        em.flush();
    }

    @Override
    public E procuraPorId(PK id) {
        return (E) em.find(clazz, id);
    }

    @Override
    public E atualiza(E entity) {
        em.merge(entity);
        em.flush();
        return entity;
    }

    public Collection<E> listarTodos() {
        return em.createQuery("from " + clazz.getName()).getResultList();
    }
}
