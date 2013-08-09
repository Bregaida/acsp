/**
 * 
 */
package br.com.acsp.curso.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.acsp.curso.domain.clazz.Instrutor;
import br.com.acsp.curso.util.HibernateUtil;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

/**
 * @author eduardobregaida
 * 
 */

@Component
@RequestScoped
public class InstrutorDAOImpl implements InstrutorDAO {

	private Logger logger = Logger.getLogger(InstrutorDAOImpl.class);

	public Boolean salvar(Instrutor instrutor) {
		Session sessao = null;
		Transaction transacao = null;
		boolean salvou;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(instrutor);
			transacao.commit();
			salvou = true;
		} catch (Exception e) {
			transacao.rollback();
			salvou = false;
			logger.info("Erro ao salvar Instrutor: " + e.getMessage());
		} finally {
			sessao.close();
		}
		return salvou;
	}

	public Boolean atualizar(Instrutor instrutor) {
		Session sessao = null;
		Transaction transacao = null;
		boolean atualizou;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(instrutor);
			transacao.commit();
			atualizou = true;
		} catch (Exception e) {
			transacao.rollback();
			atualizou = false;
			logger.info("Erro ao atualizar Instrutor: " + e.getMessage());
		} finally {
			sessao.close();
		}
		return atualizou;
	}

	public Boolean excluir(Instrutor instrutor) {
		Session sessao = null;
		Transaction transacao = null;
		boolean excluiu;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(instrutor);
			transacao.commit();
			excluiu = true;
		} catch (Exception e) {
			transacao.rollback();
			excluiu = false;
			logger.info("Erro ao excluir Instrutor: " + e.getMessage());
		} finally {
			sessao.close();
		}
		return excluiu;
	}

	@SuppressWarnings("unchecked")
	public List<Instrutor> pesquisarTodos() {
		Session sessao = null;
		Transaction transacao = null;
		List<Instrutor> instrutores = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			instrutores = sessao.createCriteria(Instrutor.class.getName())
					.list();
			transacao.commit();
		} catch (Exception e) {
			transacao.rollback();
			logger.info("Erro pesquisar todos Instrutores: " + e.getMessage());
		} finally {
			sessao.close();
		}
		return instrutores;
	}

}
