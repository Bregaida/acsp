/**
 *
 */
package br.com.acsp.curso.service;

import br.com.acsp.curso.domain.Atendente;
import br.com.acsp.curso.repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author eduardobregaida
 */

@Service
@Transactional
public class AtendenteService extends AbstractService<Atendente, String> {

    @Autowired
    public void setRepository(AtendenteRepository repository) {
        super.repository = repository;
    }

    @Override
    protected String getSortAttribute() {
        return "nome";
    }
}
