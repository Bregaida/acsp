package br.com.acsp.curso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.acsp.curso.domain.Agenda;
import br.com.acsp.curso.repository.AgendaRepository;

/**
 * @author pedrosa
 * 
 */

@Service
public class AgendaService extends AbstractService<Agenda, Long> {

	@Autowired
	public void setRepository(AgendaRepository repository) {
		super.repository = repository;
	}

}
