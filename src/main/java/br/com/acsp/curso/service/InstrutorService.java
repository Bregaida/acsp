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
 */

@Service
public class InstrutorService extends AbstractService<Instrutor, Long> {

    @Autowired
    public void setRepository(InstrutorRepository repository) {
        super.repository = repository;
    }
}
