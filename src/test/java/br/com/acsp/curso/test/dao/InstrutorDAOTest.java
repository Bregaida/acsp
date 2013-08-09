/**
 * 
 */
package br.com.acsp.curso.test.dao;

import org.junit.Assert;
import org.junit.Test;

import br.com.acsp.curso.dao.InstrutorDAO;
import br.com.acsp.curso.dao.InstrutorDAOImpl;
import br.com.acsp.curso.domain.clazz.Instrutor;
import br.com.acsp.curso.test.UtilTest;

/**
 * @author eduardobregaida
 * 
 */
public class InstrutorDAOTest {

	private InstrutorDAO dao = new InstrutorDAOImpl();

	@Test
	public void deveriaSalvarInstrutor() {
		Assert.assertTrue(dao.salvar(UtilTest.populaInstrutor()));
	}

	@Test
	public void deveriaAtualizarInstrutor() {
		Instrutor instrutor = new Instrutor();
		instrutor = UtilTest.populaInstrutor();
		instrutor.setId(dao.pesquisarTodos().iterator().next().getId());
		instrutor.setNome("Airton");
		Assert.assertTrue(dao.atualizar(instrutor));
	}

	@Test
	public void deveriaExcluirInstrutor() {
		Instrutor instrutor = new Instrutor();
		instrutor = UtilTest.populaInstrutor();
		instrutor.setId(dao.pesquisarTodos().iterator().next().getId());
		Assert.assertTrue(dao.excluir(instrutor));
	}

	@Test
	public void deveriaPesquisarTodosInstrutores() {
		Assert.assertNotNull(dao.pesquisarTodos());
	}

}
