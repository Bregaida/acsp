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
 */

@Service
public class AtendenteService extends AbstractService<Atendente, Long> {

    @Autowired
    public void setRepository(AtendenteRepository repository) {
        super.repository = repository;
    }
}
