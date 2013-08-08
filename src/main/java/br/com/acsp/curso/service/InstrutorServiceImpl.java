/**
 * 
 */
package br.com.acsp.curso.service;

import java.util.List;

import br.com.acsp.curso.dao.InstrutorDAO;
import br.com.acsp.curso.dao.InstrutorDAOImpl;
import br.com.acsp.curso.domain.clazz.Instrutor;
import br.com.caelum.vraptor.ioc.Component;

/**
 * @author eduardobregaida
 * 
 */

@Component
public class InstrutorServiceImpl implements InstrutorService {

	// TODO: remover esse new
	private InstrutorDAO dao = new InstrutorDAOImpl();

	public Boolean salvar(Instrutor instrutor) {
		return dao.salvar(instrutor);
	}

	public Boolean alterar(Instrutor instrutor) {
		return dao.alterar(instrutor);
	}

	public Boolean excluir(Instrutor instrutor) {
		return dao.excluir(instrutor);
	}

	public List<Instrutor> pesquisarTodos() {
		return dao.pesquisarTodos();
	}

}
