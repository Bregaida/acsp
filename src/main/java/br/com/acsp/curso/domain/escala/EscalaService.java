/**
 * 
 */
package br.com.acsp.curso.domain.escala;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import br.com.acsp.curso.common.AbstractService;

/**
 * @author eduardobregaida
 * 
 */

@Service
public class EscalaService extends AbstractService<Escala, String> {

    @Autowired
    private EscalaRepository escalaRepository;

    @Override
    public MongoRepository getRepository() {
	return (MongoRepository) this.escalaRepository;
    }

    @Override
    public String getSortAttribute() {
	return "dataEscala";
    }

}
