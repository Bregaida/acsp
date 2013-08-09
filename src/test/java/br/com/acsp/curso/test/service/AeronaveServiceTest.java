/**
 * 
 */
package br.com.acsp.curso.test.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.acsp.curso.service.AeronaveService;
import br.com.acsp.curso.service.AeronaveServiceImpl;
import br.com.acsp.curso.test.UtilTest;

/**
 * @author eduardobregaida
 * 
 */
public class AeronaveServiceTest {

	private AeronaveService service = new AeronaveServiceImpl();

	@Test
	public void deveriaSalvarAeronave() {
		assertNotNull(service.salvar(UtilTest.populaAeronave()));
	}

	@Test
	public void deveriaAlterarAeronave() {
		assertNotNull(service.atualizar(UtilTest.populaAeronave()));
	}

	@Test
	public void deveriaExcluirAeronave() {
		assertNotNull(service.excluir(UtilTest.populaAeronave()));
	}

	@Test
	public void deveriaPesquisarTodosAeronaves() {
		assertNotNull(service.pesquisarTodos());
	}

}
