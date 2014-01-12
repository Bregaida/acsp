/**
 *
 */
package br.com.acsp.curso.service;

import br.com.acsp.curso.domain.Aula;
import br.com.acsp.curso.repository.AeronaveRepository;
import br.com.acsp.curso.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eduardobregaida
 */

@Service
public class AulaService extends AbstractService<Aula, String> {

    @Autowired
    private AeronaveRepository aeronaveRepository;

    @Autowired
    public void setRepository(AulaRepository repository) {
        super.repository = repository;
    }

    @Override
    protected String getSortAttribute() {
        return "materia";
    }
}
