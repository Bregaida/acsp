/**
 * 
 */
package br.com.acsp.curso.test.dao;

import org.junit.Assert;
import org.junit.Test;

import br.com.acsp.curso.dao.AtendenteDAO;
import br.com.acsp.curso.dao.AtendenteDAOImpl;
import br.com.acsp.curso.domain.clazz.Atendente;
import br.com.acsp.curso.test.UtilTest;

/**
 * @author eduardobregaida
 * 
 */
public class AtendenteDAOTest {

	private AtendenteDAO dao = new AtendenteDAOImpl();

	@Test
	public void deveriaSalvarAtendente() {
		Assert.assertTrue(dao.salvar(UtilTest.populaAtendente()));
	}

	@Test
	public void deveriaAtualizarAtendente() {
		Atendente atendente = new Atendente();
		atendente = UtilTest.populaAtendente();
		atendente.setId(dao.pesquisarTodos().iterator().next().getId());
		atendente.setNome("Airton");
		Assert.assertTrue(dao.atualizar(atendente));
	}

	@Test
	public void deveriaExcluirAtendente() {
		Atendente atendente = new Atendente();
		atendente = UtilTest.populaAtendente();
		atendente.setId(dao.pesquisarTodos().iterator().next().getId());
		Assert.assertTrue(dao.excluir(atendente));
	}

	@Test
	public void deveriaPesquisarTodosAtendentes() {
		Assert.assertNotNull(dao.pesquisarTodos());
	}

}
