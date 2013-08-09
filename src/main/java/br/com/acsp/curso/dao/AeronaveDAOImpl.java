/**
 * 
 */
package br.com.acsp.curso.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.acsp.curso.domain.clazz.Aeronave;
import br.com.acsp.curso.util.HibernateUtil;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

/**
 * @author eduardobregaida
 * 
 */

@Component
@RequestScoped
public class AeronaveDAOImpl implements AeronaveDAO {

	private Logger logger = Logger.getLogger(AeronaveDAOImpl.class);

	public Boolean salvar(Aeronave aeronave) {
		Session sessao = null;
		Transaction transacao = null;
		boolean salvou;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(aeronave);
			transacao.commit();
			salvou = true;
		} catch (Exception e) {
			transacao.rollback();
			salvou = false;
			logger.info("Erro ao salvar Aeronave: " + e.getMessage());
		} finally {
			sessao.close();
		}
		return salvou;
	}

	public Boolean atualizar(Aeronave aeronave) {
		Session sessao = null;
		Transaction transacao = null;
		boolean atualizou;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(aeronave);
			transacao.commit();
			atualizou = true;
		} catch (Exception e) {
			transacao.rollback();
			atualizou = false;
			logger.info("Erro ao atualizar Aeronave: " + e.getMessage());
		} finally {
			sessao.close();
		}
		return atualizou;
	}

	public Boolean excluir(Aeronave aeronave) {
		Session sessao = null;
		Transaction transacao = null;
		boolean excluiu;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(aeronave);
			transacao.commit();
			excluiu = true;
		} catch (Exception e) {
			transacao.rollback();
			excluiu = false;
			logger.info("Erro ao excluir Aeronave: " + e.getMessage());
		} finally {
			sessao.close();
		}
		return excluiu;
	}

	@SuppressWarnings("unchecked")
	public List<Aeronave> pesquisarTodos() {
		Session sessao = null;
		Transaction transacao = null;
		List<Aeronave> aeronaves = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			aeronaves = sessao.createCriteria(Aeronave.class.getName()).list();
			transacao.commit();
		} catch (Exception e) {
			transacao.rollback();
			logger.info("Erro pesquisar todas Aeronaves: " + e.getMessage());
		} finally {
			sessao.close();
		}
		return aeronaves;
	}

}
