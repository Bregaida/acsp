/**
 * 
 */
package br.com.acsp.curso.dao;

import java.util.List;

import br.com.acsp.curso.domain.clazz.Atendente;

/**
 * @author eduardobregaida
 * 
 */
public interface AtendenteDAO {

	public Boolean salvar(Atendente atendente);

	public Boolean atualizar(Atendente atendente);

	public Boolean excluir(Atendente atendente);

	public List<Atendente> pesquisarTodos();
}
