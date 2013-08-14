/**
 * 
 */
package br.com.acsp.curso.service;

import br.com.acsp.curso.domain.Atendente;
import br.com.acsp.curso.repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eduardobregaida
 * 
 */

<<<<<<< HEAD
public interface AtendenteService {

	public Boolean salvar(Atendente atendente);

	public Boolean atualizar(Atendente atendente);

	public Boolean excluir(Atendente atendente);

	public List<Atendente> pesquisarTodos();
=======
@Service
public class AtendenteService extends AbstractService<Atendente, Long> {
>>>>>>> pr/1

    @Autowired
    public void setRepository(AtendenteRepository repository){
        super.repository = repository;
    }
}
