/**
 * 
 */
package br.com.acsp.curso.dao;

import java.util.List;

import br.com.acsp.curso.domain.clazz.Aeronave;

/**
 * @author eduardobregaida
 * 
 */
public interface AeronaveDAO {

	public Boolean salvar(Aeronave aeronave);

	public Boolean alterar(Aeronave aeronave);

	public Boolean excluir(Aeronave aeronave);

	public List<Aeronave> pesquisarTodos();
}
