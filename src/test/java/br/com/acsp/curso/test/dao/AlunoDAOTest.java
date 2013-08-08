/**
 * 
 */
package br.com.acsp.curso.test.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;

import br.com.acsp.curso.dao.AlunoDAO;
import br.com.acsp.curso.dao.AlunoDAOImpl;
import br.com.acsp.curso.test.UtilTest;

/**
 * @author eduardobregaida
 * 
 */
public class AlunoDAOTest {

	private AlunoDAO dao = new AlunoDAOImpl();

	@Test
	public void deveriaSalvarAluno() {
		Assert.assertTrue(dao.salvar(UtilTest.populaAluno()));
	}

	@Test
	public void deveriaAlterarAluno() {
		assertNotNull(dao.alterar(UtilTest.populaAluno()));
	}

	@Test
	public void deveriaExcluirAluno() {
		assertNotNull(dao.excluir(UtilTest.populaAluno()));
	}

	@Test
	public void deveriaPesquisarTodosAlunos() {
		assertNotNull(dao.pesquisarTodos());
	}

}
