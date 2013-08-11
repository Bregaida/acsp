package br.com.acsp.curso.repository.jpa;

import br.com.acsp.curso.repository.GenericRepository;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
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
public abstract class JpaGenericDAO<E> implements GenericRepository<E> {

    private final Logger LOGGER = LoggerFactory.getLogger(JpaGenericDAO.class);

    @PersistenceContext
    protected EntityManager em;

    private Class clazz;

    public JpaGenericDAO(Class clazz){
        LOGGER.info("Pertence a " + clazz);
        this.clazz = clazz;
    }

    @Override
    public void exclui(E entity){
        em.detach(entity);
    }

    @Override
    public void salva(E entity){
        System.out.println("Salvando DAO " + ToStringBuilder.reflectionToString(entity, ToStringStyle.MULTI_LINE_STYLE));
        em.persist(entity);
    }

    @Override
    public E procuraPorId(Long id){
        return (E) em.find(clazz, id);
    }

    @Override
    public E atualiza(E entity){
        return em.merge(entity);
    }

    public Collection<E> listarTodos(){
        return em.createQuery("from " + clazz.getName() ).getResultList();
    }
}
