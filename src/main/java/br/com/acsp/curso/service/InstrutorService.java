/**
 * 
 */
package br.com.acsp.curso.service;

import java.util.List;

import br.com.acsp.curso.domain.clazz.Instrutor;

/**
 * @author eduardobregaida
 * 
 */
public interface InstrutorService {

	public Boolean salvar(Instrutor instrutor);

	public Boolean alterar(Instrutor instrutor);

	public Boolean excluir(Instrutor instrutor);

	public List<Instrutor> pesquisarTodos();

}
