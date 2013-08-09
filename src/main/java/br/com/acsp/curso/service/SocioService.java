/**
 * 
 */
package br.com.acsp.curso.service;

import java.util.List;

import br.com.acsp.curso.domain.clazz.Socio;

/**
 * @author eduardobregaida
 * 
 */
public interface SocioService {

	public Boolean salvar(Socio socio);

	public Boolean atualizar(Socio socio);

	public Boolean excluir(Socio socio);

	public List<Socio> pesquisarTodos();
}
