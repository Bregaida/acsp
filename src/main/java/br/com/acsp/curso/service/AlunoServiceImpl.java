/**
 * 
 */
package br.com.acsp.curso.service;

import java.util.List;

import br.com.acsp.curso.dao.AlunoDAO;
import br.com.acsp.curso.dao.AlunoDAOImpl;
import br.com.acsp.curso.domain.clazz.Aluno;
import br.com.caelum.vraptor.ioc.Component;

/**
 * @author eduardobregaida
 * 
 */

@Component
public class AlunoServiceImpl implements AlunoService {

	// TODO: remover esse new
	private AlunoDAO dao = new AlunoDAOImpl();

	public Boolean salvar(Aluno aluno) {
		return dao.salvar(aluno);
	}

	public Boolean atualizar(Aluno aluno) {
		return dao.atualizar(aluno);
	}

	public Boolean excluir(Aluno aluno) {
		return dao.excluir(aluno);
	}

	public List<Aluno> pesquisarTodos() {
		return dao.pesquisarTodos();
	}

}
