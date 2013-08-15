/**
 *
 */
package br.com.acsp.curso.service;

import br.com.acsp.curso.domain.Socio;
import br.com.acsp.curso.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eduardobregaida
 */

@Service
public class SocioService extends AbstractService<Socio, Long> {

    @Autowired
    public void setRepository(SocioRepository repository) {
        super.repository = repository;
    }
}
