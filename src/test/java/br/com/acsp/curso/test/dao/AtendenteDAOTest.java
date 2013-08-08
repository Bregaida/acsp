/**
 * 
 */
package br.com.acsp.curso.test.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.acsp.curso.dao.AtendenteDAO;
import br.com.acsp.curso.dao.AtendenteDAOImpl;
import br.com.acsp.curso.test.UtilTest;

/**
 * @author eduardobregaida
 * 
 */
public class AtendenteDAOTest {

	private AtendenteDAO dao = new AtendenteDAOImpl();

	@Test
	public void deveriaSalvarAtendente() {
		assertNotNull(dao.salvar(UtilTest.populaAtendente()));
	}

	@Test
	public void deveriaAlterarAtendente() {
		assertNotNull(dao.alterar(UtilTest.populaAtendente()));
	}

	@Test
	public void deveriaExcluirAtendente() {
		assertNotNull(dao.excluir(UtilTest.populaAtendente()));
	}

	@Test
	public void deveriaPesquisarTodosAtendentes() {
		assertNotNull(dao.pesquisarTodos());
	}

}
