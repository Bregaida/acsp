package br.com.acsp.curso.service;

import br.com.acsp.curso.domain.Agenda;
import br.com.acsp.curso.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pedrosa
 */

@Service
public class AgendaService extends AbstractService<Agenda, Long> {

    @Autowired
    public void setRepository(AgendaRepository repository) {
        super.repository = repository;
    }

}
