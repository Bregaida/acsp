/**
 * 
 */
package br.com.acsp.curso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.acsp.curso.dao.AeronaveDAO;
import br.com.acsp.curso.dao.AeronaveDAOImpl;
import br.com.acsp.curso.domain.clazz.Aeronave;

/**
 * @author eduardobregaida
 * 
 */

@Service
public class AeronaveServiceImpl implements AeronaveService {

	// TODO: remover esse new
	private AeronaveDAO dao = new AeronaveDAOImpl();

	public Boolean salvar(Aeronave aeronave) {
		return dao.salvar(aeronave);
	}

	public Boolean atualizar(Aeronave aeronave) {
		return dao.atualizar(aeronave);
	}

	public Boolean excluir(Aeronave aeronave) {
		return dao.excluir(aeronave);
	}

	public List<Aeronave> pesquisarTodos() {
		return dao.pesquisarTodos();
	}

}
