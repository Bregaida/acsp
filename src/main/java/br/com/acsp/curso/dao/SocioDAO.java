/**
 * 
 */
package br.com.acsp.curso.dao;

import java.util.List;

import br.com.acsp.curso.domain.clazz.Socio;

/**
 * @author eduardobregaida
 * 
 */

public interface SocioDAO {

	public Boolean salvar(Socio socio);

	public Boolean alterar(Socio socio);

	public Boolean excluir(Socio socio);

	public List<Socio> pesquisarTodos();
}
