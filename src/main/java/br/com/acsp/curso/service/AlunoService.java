/**
 * 
 */
package br.com.acsp.curso.service;

import java.util.List;

import br.com.acsp.curso.domain.clazz.Aluno;

/**
 * @author eduardobregaida
 * 
 */

public interface AlunoService {

	public Boolean salvar(Aluno aluno);

	public Boolean atualizar(Aluno aluno);

	public Boolean excluir(Aluno aluno);

	public List<Aluno> pesquisarTodos();

}
