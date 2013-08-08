/**
 * 
 */
package br.com.acsp.curso.view.controller;

import java.util.List;

import br.com.acsp.curso.domain.clazz.Aluno;
import br.com.acsp.curso.service.AlunoService;
import br.com.acsp.curso.view.form.AlunoForm;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

/**
 * @author eduardobregaida
 *
 */

@Resource
public class AlunoController {
	
	private final Result result;
	private final Validator validator;
	private final AlunoService alunoService;
    
	 public AlunoController(AlunoService alunoService, Result result, Validator validator) {
	        this.alunoService = alunoService;
			this.result = result;
			this.validator = validator;
	    }

	 public void formulario(){
			
		}
	 
	 @Post
		public void salvar(final AlunoForm alunoForm){
			 validator.checking(new Validations(){{
		            that(!alunoForm.getAluno().getNome().isEmpty(),"erro", "aluno.nome.nao.informado");
		        }});
		        validator.onErrorUsePageOf(this).formulario();  
		 
		        alunoService.salvar(alunoForm.getAluno());
		        result.redirectTo(this).lista();
		}
	    
	    public void remover (AlunoForm alunoForm){
	    	alunoService.excluir(alunoForm.getAluno());
			result.nothing();
		}
	    
	    public List<Aluno> lista() {
			return alunoService.pesquisarTodos();
		}
		
}
