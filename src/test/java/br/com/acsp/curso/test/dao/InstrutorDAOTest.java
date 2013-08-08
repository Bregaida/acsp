/**
 * 
 */
package br.com.acsp.curso.test.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.acsp.curso.dao.InstrutorDAO;
import br.com.acsp.curso.dao.InstrutorDAOImpl;
import br.com.acsp.curso.test.UtilTest;

/**
 * @author eduardobregaida
 * 
 */
public class InstrutorDAOTest {

	private InstrutorDAO dao = new InstrutorDAOImpl();

	@Test
	public void deveriaSalvarInstrutor() {
		assertNotNull(dao.salvar(UtilTest.populaInstrutor()));
	}

	@Test
	public void deveriaAlterarInstrutor() {
		assertNotNull(dao.alterar(UtilTest.populaInstrutor()));
	}

	@Test
	public void deveriaExcluirInstrutor() {
		assertNotNull(dao.excluir(UtilTest.populaInstrutor()));
	}

	@Test
	public void deveriaPesquisarTodosInstrutores() {
		assertNotNull(dao.pesquisarTodos());
	}

}
