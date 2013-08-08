/**
 * 
 */
package br.com.acsp.curso.service;

import java.util.List;

import br.com.acsp.curso.dao.SocioDAO;
import br.com.acsp.curso.dao.SocioDAOImpl;
import br.com.acsp.curso.domain.clazz.Socio;
import br.com.caelum.vraptor.ioc.Component;

/**
 * @author eduardobregaida
 * 
 */

@Component
public class SocioServiceImpl implements SocioService {

	// TODO: remover esse new
	private SocioDAO dao = new SocioDAOImpl();

	public Boolean salvar(Socio socio) {
		return dao.salvar(socio);
	}

	public Boolean alterar(Socio socio) {
		return dao.alterar(socio);
	}

	public Boolean excluir(Socio socio) {
		return dao.excluir(socio);
	}

	public List<Socio> pesquisarTodos() {
		return dao.pesquisarTodos();
	}

}
