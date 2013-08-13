/**
 * 
 */
package br.com.acsp.curso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.acsp.curso.dao.SocioDAO;
import br.com.acsp.curso.dao.SocioDAOImpl;
import br.com.acsp.curso.domain.clazz.Socio;

/**
 * @author eduardobregaida
 * 
 */

@Service
public class SocioServiceImpl implements SocioService {

	// TODO: remover esse new
	private SocioDAO dao = new SocioDAOImpl();

	public Boolean salvar(Socio socio) {
		return dao.salvar(socio);
	}

	public Boolean atualizar(Socio socio) {
		return dao.atualizar(socio);
	}

	public Boolean excluir(Socio socio) {
		return dao.excluir(socio);
	}

	public List<Socio> pesquisarTodos() {
		return dao.pesquisarTodos();
	}

}
