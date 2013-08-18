/**
 *
 */
package br.com.acsp.curso.repository;

import java.util.Collection;

import br.com.acsp.curso.domain.Instrutor;

/**
 * @author eduardobregaida
 */
public interface InstrutorRepository extends GenericRepository<Instrutor, Long> {

	Collection<Instrutor> listarOrdenadoPorNome();
	
	//TODO Criar instrutores disponiveis
	
	
}
