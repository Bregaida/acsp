/**
 * 
 */
package br.com.acsp.curso.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.acsp.curso.domain.clazz.Aluno;
import br.com.acsp.curso.util.HibernateUtil;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

/**
 * @author eduardobregaida
 *
 */

@Component
@RequestScoped
public class AlunoDAOImpl implements AlunoDAO {

	private static List<Aluno> alunos;

	public AlunoDAOImpl() {
		if(alunos == null){
			alunos = new ArrayList<Aluno>();
		}
	}
	
	public Boolean salvar(Aluno aluno) {
		try{
			Session sessao = null;  
		    Transaction transacao = null;  
		      
		    sessao = HibernateUtil.getSessionFactory().openSession();//n‹o inicia a sess‹o no hibernate 4  
		    transacao = sessao.beginTransaction();  
		    sessao.save(aluno);  
		    transacao.commit();  
		      
		    sessao.close();  
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	public Boolean alterar(Aluno aluno) {
		return alunos.add(aluno);
	}

	public Boolean excluir(Aluno aluno) {
		Iterator<Aluno> it = alunos.iterator();
		while(it.hasNext()) {
			Aluno alunoExistente = it.next();
			if(alunoExistente.getId().equals(alunoExistente.getId())) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> pesquisarTodos() {
		 return HibernateUtil.getSessionFactory().openSession().createQuery("FROM " + Aluno.class.getName()).list();
//		return Collections.unmodifiableList(alunos);
	}

}
