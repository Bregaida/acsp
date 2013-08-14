/**
 * 
 */
package br.com.acsp.curso.service;

import br.com.acsp.curso.domain.Instrutor;
import br.com.acsp.curso.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eduardobregaida
 * 
 */
<<<<<<< HEAD
public interface InstrutorService {

	public Boolean salvar(Instrutor instrutor);

	public Boolean atualizar(Instrutor instrutor);

	public Boolean excluir(Instrutor instrutor);
=======
>>>>>>> pr/1

@Service
public class InstrutorService extends AbstractService<Instrutor, Long> {

    @Autowired
    public void setRepository(InstrutorRepository repository){
        super.repository = repository;
    }
}
