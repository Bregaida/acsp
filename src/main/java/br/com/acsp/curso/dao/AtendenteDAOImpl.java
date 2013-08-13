/**
 * 
 */
package br.com.acsp.curso.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.acsp.curso.domain.clazz.Atendente;
import br.com.acsp.curso.util.HibernateUtil;

/**
 * @author eduardobregaida
 * 
 */

@Repository
public class AtendenteDAOImpl implements AtendenteDAO {

	private Logger logger = LoggerFactory.getLogger(AtendenteDAOImpl.class);

	public Boolean salvar(Atendente atendente) {
		Session sessao = null;
		Transaction transacao = null;
		boolean salvou;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(atendente);
			transacao.commit();
			salvou = true;
		} catch (Exception e) {
			transacao.rollback();
			salvou = false;
			logger.info("Erro ao salvar Atendente: " + e.getMessage());
		} finally {
			sessao.close();
		}
		return salvou;
	}

	public Boolean atualizar(Atendente atendente) {
		Session sessao = null;
		Transaction transacao = null;
		boolean atualizou;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(atendente);
			transacao.commit();
			atualizou = true;
		} catch (Exception e) {
			transacao.rollback();
			atualizou = false;
			logger.info("Erro ao atualizar Atendente: " + e.getMessage());
		} finally {
			sessao.close();
		}
		return atualizou;
	}

	public Boolean excluir(Atendente atendente) {
		Session sessao = null;
		Transaction transacao = null;
		boolean excluiu;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(atendente);
			transacao.commit();
			excluiu = true;
		} catch (Exception e) {
			transacao.rollback();
			excluiu = false;
			logger.info("Erro ao excluir Atendente: " + e.getMessage());
		} finally {
			sessao.close();
		}
		return excluiu;
	}

	@SuppressWarnings("unchecked")
	public List<Atendente> pesquisarTodos() {
		Session sessao = null;
		Transaction transacao = null;
		List<Atendente> atendentes = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			atendentes = sessao.createCriteria(Atendente.class.getName())
					.list();
			transacao.commit();
		} catch (Exception e) {
			transacao.rollback();
			logger.info("Erro pesquisar todos Atendentes: " + e.getMessage());
		} finally {
			sessao.close();
		}
		return atendentes;
	}

}
