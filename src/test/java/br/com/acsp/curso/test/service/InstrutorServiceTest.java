/**
 * 
 */
package br.com.acsp.curso.test.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.acsp.curso.service.InstrutorService;
import br.com.acsp.curso.service.InstrutorServiceImpl;
import br.com.acsp.curso.test.UtilTest;

/**
 * @author eduardobregaida
 * 
 */
public class InstrutorServiceTest {

	private InstrutorService service = new InstrutorServiceImpl();

	@Test
	public void deveriaSalvarInstrutor() {
		assertNotNull(service.salvar(UtilTest.populaInstrutor()));
	}

	@Test
	public void deveriaAlterarInstrutor() {
		assertNotNull(service.atualizar(UtilTest.populaInstrutor()));
	}

	@Test
	public void deveriaExcluirInstrutor() {
		assertNotNull(service.excluir(UtilTest.populaInstrutor()));
	}

	@Test
	public void deveriaPesquisarTodosInstrutores() {
		assertNotNull(service.pesquisarTodos());
	}

}
