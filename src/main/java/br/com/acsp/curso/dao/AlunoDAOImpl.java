/**
 * 
 */
package br.com.acsp.curso.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import br.com.acsp.curso.domain.clazz.Aluno;
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
		return alunos.add(aluno);
		
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

	public List<Aluno> pesquisarTodos() {
		return Collections.unmodifiableList(alunos);
	}

}
