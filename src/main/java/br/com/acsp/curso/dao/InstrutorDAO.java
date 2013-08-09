/**
 * 
 */
package br.com.acsp.curso.dao;

import java.util.List;

import br.com.acsp.curso.domain.clazz.Instrutor;

/**
 * @author eduardobregaida
 * 
 */
public interface InstrutorDAO {

	public Boolean salvar(Instrutor instrutor);

	public Boolean atualizar(Instrutor instrutor);

	public Boolean excluir(Instrutor instrutor);

	public List<Instrutor> pesquisarTodos();

}
