/**
 * 
 */
package br.com.acsp.curso.service;

import br.com.acsp.curso.domain.Aeronave;
import br.com.acsp.curso.repository.AeronaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eduardobregaida
 * 
 */
<<<<<<< HEAD
public interface AeronaveService {

	public Boolean salvar(Aeronave aeronave);

	public Boolean atualizar(Aeronave aeronave);

	public Boolean excluir(Aeronave aeronave);
=======
>>>>>>> pr/1

@Service
public class AeronaveService extends AbstractService<Aeronave, Long> {

    @Autowired
    public void setRepository(AeronaveRepository repository){
        super.repository = repository;
    }
}
