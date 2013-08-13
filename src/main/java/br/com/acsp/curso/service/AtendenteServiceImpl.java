/**
 * 
 */
package br.com.acsp.curso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.acsp.curso.dao.AtendenteDAO;
import br.com.acsp.curso.dao.AtendenteDAOImpl;
import br.com.acsp.curso.domain.clazz.Atendente;

/**
 * @author eduardobregaida
 * 
 */

@Service
public class AtendenteServiceImpl implements AtendenteService {

	// TODO: remover esse new
	private AtendenteDAO dao = new AtendenteDAOImpl();

	public Boolean salvar(Atendente atendente) {
		return dao.salvar(atendente);
	}

	public Boolean atualizar(Atendente atendente) {
		return dao.atualizar(atendente);
	}

	public Boolean excluir(Atendente atendente) {
		return dao.excluir(atendente);
	}

	public List<Atendente> pesquisarTodos() {
		return dao.pesquisarTodos();
	}

}
