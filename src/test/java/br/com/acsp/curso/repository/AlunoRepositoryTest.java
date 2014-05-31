package br.com.acsp.curso.repository;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.acsp.curso.domain.aluno.Aluno;
import br.com.acsp.curso.domain.aluno.AlunoRepository;

/**
 * @author thiago
 *
 */
public class AlunoRepositoryTest extends AbstractRepositoryTestSupport {
	
	@Autowired private AlunoRepository alunoRepository;
	
	@Rule public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void testAlunosListNotNullAndGraterThanZero() {
		List<Aluno> alunos = alunoRepository.findAll();
		assertThat(alunos.size(), is(notNullValue()));
		assertThat(alunos.size(), is(greaterThan(0)));
	}
	
	@Test
	public void testAlunoDoesNotExist() {
		Aluno aluno = alunoRepository.findOne("joselito");
		assertThat(aluno, is(nullValue()));
	}
	
	@Test
	public void testAlunoNullPointerException() {
		Aluno aluno = alunoRepository.findOne("aluno not found");
		expectedException.expect(NullPointerException.class);
		aluno.getNome();
	}
}