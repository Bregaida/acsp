/**
 * 
 */
package br.com.acsp.curso.service;

import br.com.acsp.curso.domain.Aluno;
import br.com.acsp.curso.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @author eduardobregaida
 * 
 */

@Service
@Transactional
public class AlunoService extends AbstractService<Aluno, Long>{

<<<<<<< HEAD
	public Boolean salvar(Aluno aluno);

	public Boolean atualizar(Aluno aluno);

	public Boolean excluir(Aluno aluno);

	public List<Aluno> pesquisarTodos();
=======
    @Autowired
	public void setRepository(AlunoRepository repository){
        super.repository = repository;
    }
>>>>>>> pr/1

    public Collection<Aluno> listarOrdenado(){
        return ((AlunoRepository) repository).listarOrdenadoPorNome();
    }
}
