/**
 * 
 */
package br.com.acsp.curso.test.dao;

import org.junit.Assert;
import org.junit.Test;

import br.com.acsp.curso.dao.AeronaveDAO;
import br.com.acsp.curso.dao.AeronaveDAOImpl;
import br.com.acsp.curso.domain.clazz.Aeronave;
import br.com.acsp.curso.test.UtilTest;

/**
 * @author eduardobregaida
 * 
 */
public class AeronaveDAOTest {

	private AeronaveDAO dao = new AeronaveDAOImpl();

	@Test
	public void deveriaSalvarAeronave() {
		Assert.assertTrue(dao.salvar(UtilTest.populaAeronave()));
	}

	@Test
	public void deveriaAtualizarAeronave() {
		Aeronave aeronave = new Aeronave();
		aeronave = UtilTest.populaAeronave();
		aeronave.setId(dao.pesquisarTodos().iterator().next().getId());
		aeronave.setModelo("Arrow");
		Assert.assertTrue(dao.atualizar(aeronave));
	}

	@Test
	public void deveriaExcluirAeronave() {
		Aeronave aeronave = new Aeronave();
		aeronave = UtilTest.populaAeronave();
		aeronave.setId(dao.pesquisarTodos().iterator().next().getId());
		Assert.assertTrue(dao.excluir(aeronave));
	}

	@Test
	public void deveriaPesquisarTodosAeronaves() {
		Assert.assertNotNull(dao.pesquisarTodos());
	}

}
