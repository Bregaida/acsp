/**
 * 
 */
package br.com.acsp.curso.test.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.acsp.curso.service.AlunoService;
import br.com.acsp.curso.service.AlunoServiceImpl;
import br.com.acsp.curso.test.UtilTest;

/**
 * @author eduardobregaida
 * 
 */
public class AlunoServiceTest {

	private AlunoService service = new AlunoServiceImpl();

	@Test
	public void deveriaSalvarAluno() {
		assertNotNull(service.salvar(UtilTest.populaAluno()));
	}

	@Test
	public void deveriaAlterarAluno() {
		assertNotNull(service.alterar(UtilTest.populaAluno()));
	}

	@Test
	public void deveriaExcluirAluno() {
		assertNotNull(service.excluir(UtilTest.populaAluno()));
	}

	@Test
	public void deveriaPesquisarTodosAlunos() {
		assertNotNull(service.pesquisarTodos());
	}

}
