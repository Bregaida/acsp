/**
 * 
 */
package br.com.acsp.curso.test.dao;

import org.junit.Assert;
import org.junit.Test;

import br.com.acsp.curso.dao.AlunoDAO;
import br.com.acsp.curso.dao.AlunoDAOImpl;
import br.com.acsp.curso.domain.clazz.Aluno;
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
	public void deveriaAtualizarAluno() {
		Aluno aluno = new Aluno();
		aluno = UtilTest.populaAluno();
		aluno.setId(dao.pesquisarTodos().iterator().next().getId());
		aluno.setNome("Airton");
		Assert.assertTrue(dao.atualizar(aluno));
	}

	@Test
	public void deveriaExcluirAluno() {
		Aluno aluno = new Aluno();
		aluno = UtilTest.populaAluno();
		aluno.setId(dao.pesquisarTodos().iterator().next().getId());
		Assert.assertTrue(dao.excluir(aluno));
	}

	@Test
	public void deveriaPesquisarTodosAlunos() {
		Assert.assertNotNull(dao.pesquisarTodos());
	}

}
