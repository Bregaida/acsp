/**
 * 
 */
package br.com.acsp.curso.view.controller;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.acsp.curso.domain.clazz.Aluno;
import br.com.acsp.curso.service.AlunoService;
import br.com.acsp.curso.view.form.AlunoForm;

/**
 * @author eduardobregaida
 * 
 */

@Component
public class AlunoController {

	private final AlunoService alunoService;

	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	public void formulario() {

	}

	public void salvar(final AlunoForm alunoForm) {
		alunoService.salvar(alunoForm.getAluno());
	}

	public void remover(AlunoForm alunoForm) {
		alunoService.excluir(alunoForm.getAluno());
	}

	public List<Aluno> lista() {
		return alunoService.pesquisarTodos();
	}

}
