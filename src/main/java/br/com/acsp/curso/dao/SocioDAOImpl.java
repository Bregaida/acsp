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

import br.com.acsp.curso.domain.clazz.Socio;
import br.com.acsp.curso.util.HibernateUtil;

/**
 * @author eduardobregaida
 * 
 */

@Repository
public class SocioDAOImpl implements SocioDAO {

	private Logger logger = LoggerFactory.getLogger(SocioDAOImpl.class);

	public Boolean salvar(Socio socio) {
		Session sessao = null;
		Transaction transacao = null;
		boolean salvou;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(socio);
			transacao.commit();
			salvou = true;
		} catch (Exception e) {
			transacao.rollback();
			salvou = false;
			logger.info("Erro ao salvar Socio: " + e.getMessage());
		} finally {
			sessao.close();
		}
		return salvou;
	}

	public Boolean atualizar(Socio socio) {
		Session sessao = null;
		Transaction transacao = null;
		boolean atualizou;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(socio);
			transacao.commit();
			atualizou = true;
		} catch (Exception e) {
			transacao.rollback();
			atualizou = false;
			logger.info("Erro ao atualizar Socio: " + e.getMessage());
		} finally {
			sessao.close();
		}
		return atualizou;
	}

	public Boolean excluir(Socio socio) {
		Session sessao = null;
		Transaction transacao = null;
		boolean excluiu;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(socio);
			transacao.commit();
			excluiu = true;
		} catch (Exception e) {
			transacao.rollback();
			excluiu = false;
			logger.info("Erro ao excluir Socio: " + e.getMessage());
		} finally {
			sessao.close();
		}
		return excluiu;
	}

	@SuppressWarnings("unchecked")
	public List<Socio> pesquisarTodos() {
		Session sessao = null;
		Transaction transacao = null;
		List<Socio> socios = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			socios = sessao.createCriteria(Socio.class.getName()).list();
			transacao.commit();
		} catch (Exception e) {
			transacao.rollback();
			logger.info("Erro pesquisar todos Socios: " + e.getMessage());
		} finally {
			sessao.close();
		}
		return socios;
	}

}
