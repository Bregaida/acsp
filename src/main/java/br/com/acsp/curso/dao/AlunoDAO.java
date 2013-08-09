/**
 * 
 */
package br.com.acsp.curso.dao;

import java.util.List;

import br.com.acsp.curso.domain.clazz.Aluno;

/**
 * @author eduardobregaida
 * 
 */
public interface AlunoDAO {

	public Boolean salvar(Aluno aluno);

	public Boolean atualizar(Aluno aluno);

	public Boolean excluir(Aluno aluno);

	public List<Aluno> pesquisarTodos();
}
