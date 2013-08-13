/**
 * 
 */
package br.com.acsp.curso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.acsp.curso.dao.InstrutorDAO;
import br.com.acsp.curso.dao.InstrutorDAOImpl;
import br.com.acsp.curso.domain.clazz.Instrutor;

/**
 * @author eduardobregaida
 * 
 */

@Service
public class InstrutorServiceImpl implements InstrutorService {

	// TODO: remover esse new
	private InstrutorDAO dao = new InstrutorDAOImpl();

	public Boolean salvar(Instrutor instrutor) {
		return dao.salvar(instrutor);
	}

	public Boolean atualizar(Instrutor instrutor) {
		return dao.atualizar(instrutor);
	}

	public Boolean excluir(Instrutor instrutor) {
		return dao.excluir(instrutor);
	}

	public List<Instrutor> pesquisarTodos() {
		return dao.pesquisarTodos();
	}

}
