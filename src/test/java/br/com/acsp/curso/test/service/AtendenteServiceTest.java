/**
 * 
 */
package br.com.acsp.curso.test.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.acsp.curso.service.AtendenteService;
import br.com.acsp.curso.service.AtendenteServiceImpl;
import br.com.acsp.curso.test.UtilTest;

/**
 * @author eduardobregaida
 * 
 */
public class AtendenteServiceTest {

	private AtendenteService service = new AtendenteServiceImpl();

	@Test
	public void deveriaSalvarAtendente() {
		assertNotNull(service.salvar(UtilTest.populaAtendente()));
	}

	@Test
	public void deveriaAlterarAtendente() {
		assertNotNull(service.alterar(UtilTest.populaAtendente()));
	}

	@Test
	public void deveriaExcluirAtendente() {
		assertNotNull(service.excluir(UtilTest.populaAtendente()));
	}

	@Test
	public void deveriaPesquisarTodosAtendentes() {
		assertNotNull(service.pesquisarTodos());
	}
}
