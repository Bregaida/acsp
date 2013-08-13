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

import br.com.acsp.curso.domain.clazz.Aluno;
import br.com.acsp.curso.util.HibernateUtil;

/**
 * @author eduardobregaida
 * 
 */

@Repository
public class AlunoDAOImpl implements AlunoDAO {

	private Logger logger = LoggerFactory.getLogger(AlunoDAOImpl.class);

	public Boolean salvar(Aluno aluno) {
		Session sessao = null;
		Transaction transacao = null;
		boolean salvou;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(aluno);
			transacao.commit();
			salvou = true;
		} catch (Exception e) {
			transacao.rollback();
			salvou = false;
			logger.info("Erro ao salvar Aluno: " + e.getMessage());
		} finally {
			sessao.close();
		}
		return salvou;
	}

	public Boolean atualizar(Aluno aluno) {
		Session sessao = null;
		Transaction transacao = null;
		boolean atualizou;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(aluno);
			transacao.commit();
			atualizou = true;
		} catch (Exception e) {
			transacao.rollback();
			atualizou = false;
			logger.info("Erro ao atualizar Aluno: " + e.getMessage());
		} finally {
			sessao.close();
		}
		return atualizou;
	}

	public Boolean excluir(Aluno aluno) {
		Session sessao = null;
		Transaction transacao = null;
		boolean excluiu;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(aluno);
			transacao.commit();
			excluiu = true;
		} catch (Exception e) {
			transacao.rollback();
			excluiu = false;
			logger.info("Erro ao excluir Aluno: " + e.getMessage());
		} finally {
			sessao.close();
		}
		return excluiu;
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> pesquisarTodos() {
		Session sessao = null;
		Transaction transacao = null;
		List<Aluno> alunos = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			alunos = sessao.createCriteria(Aluno.class.getName()).list();
			transacao.commit();
		} catch (Exception e) {
			transacao.rollback();
			logger.info("Erro pesquisar todos Alunos: " + e.getMessage());
		} finally {
			sessao.close();
		}
		return alunos;
	}

}
