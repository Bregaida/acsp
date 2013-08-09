/**
 * 
 */
package br.com.acsp.curso.test.dao;

import org.junit.Assert;
import org.junit.Test;

import br.com.acsp.curso.dao.SocioDAO;
import br.com.acsp.curso.dao.SocioDAOImpl;
import br.com.acsp.curso.domain.clazz.Socio;
import br.com.acsp.curso.test.UtilTest;

/**
 * @author eduardobregaida
 * 
 */
public class SocioDAOTest {

	private SocioDAO dao = new SocioDAOImpl();

	@Test
	public void deveriaSalvarSocio() {
		Assert.assertTrue(dao.salvar(UtilTest.populaSocio()));
	}

	@Test
	public void deveriaAtualizarSocio() {
		Socio socio = new Socio();
		socio = UtilTest.populaSocio();
		socio.setId(dao.pesquisarTodos().iterator().next().getId());
		socio.setNome("Airton");
		Assert.assertTrue(dao.atualizar(socio));
	}

	@Test
	public void deveriaExcluirSocio() {
		Socio socio = new Socio();
		socio = UtilTest.populaSocio();
		socio.setId(dao.pesquisarTodos().iterator().next().getId());
		Assert.assertTrue(dao.excluir(socio));
	}

	@Test
	public void deveriaPesquisarTodosSocios() {
		Assert.assertNotNull(dao.pesquisarTodos());
	}

}
