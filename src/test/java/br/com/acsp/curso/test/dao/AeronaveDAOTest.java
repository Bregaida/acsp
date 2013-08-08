/**
 * 
 */
package br.com.acsp.curso.test.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.acsp.curso.dao.AeronaveDAO;
import br.com.acsp.curso.dao.AeronaveDAOImpl;
import br.com.acsp.curso.test.UtilTest;

/**
 * @author eduardobregaida
 * 
 */
public class AeronaveDAOTest {

	private AeronaveDAO dao = new AeronaveDAOImpl();

	@Test
	public void deveriaSalvarAeronave() {
		assertNotNull(dao.salvar(UtilTest.populaAeronave()));
	}

	@Test
	public void deveriaAlterarAeronave() {
		assertNotNull(dao.alterar(UtilTest.populaAeronave()));
	}

	@Test
	public void deveriaExcluirAeronave() {
		assertNotNull(dao.excluir(UtilTest.populaAeronave()));
	}

	@Test
	public void deveriaPesquisarTodasAeronaves() {
		assertNotNull(dao.pesquisarTodos());
	}

}
