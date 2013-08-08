/**
 * 
 */
package br.com.acsp.curso.test.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.acsp.curso.dao.SocioDAO;
import br.com.acsp.curso.dao.SocioDAOImpl;
import br.com.acsp.curso.test.UtilTest;

/**
 * @author eduardobregaida
 * 
 */
public class SocioDAOTest {

	private SocioDAO dao = new SocioDAOImpl();

	@Test
	public void deveriaSalvarSocio() {
		assertNotNull(dao.salvar(UtilTest.populaSocio()));
	}

	@Test
	public void deveriaAlterarSocio() {
		assertNotNull(dao.alterar(UtilTest.populaSocio()));
	}

	@Test
	public void deveriaExcluirSocio() {
		assertNotNull(dao.excluir(UtilTest.populaSocio()));
	}

	@Test
	public void deveriaPesquisarTodosSocios() {
		assertNotNull(dao.pesquisarTodos());
	}

}
