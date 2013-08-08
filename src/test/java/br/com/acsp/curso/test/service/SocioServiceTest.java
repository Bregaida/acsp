/**
 * 
 */
package br.com.acsp.curso.test.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.acsp.curso.service.SocioService;
import br.com.acsp.curso.service.SocioServiceImpl;
import br.com.acsp.curso.test.UtilTest;

/**
 * @author eduardobregaida
 * 
 */
public class SocioServiceTest {

	private SocioService service = new SocioServiceImpl();

	@Test
	public void deveriaSalvarSocio() {
		assertNotNull(service.salvar(UtilTest.populaSocio()));
	}

	@Test
	public void deveriaAlterarSocio() {
		assertNotNull(service.alterar(UtilTest.populaSocio()));
	}

	@Test
	public void deveriaExcluirSocio() {
		assertNotNull(service.excluir(UtilTest.populaSocio()));
	}

	@Test
	public void deveriaPesquisarTodosSocios() {
		assertNotNull(service.pesquisarTodos());
	}

}
