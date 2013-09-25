package br.com.acsp.curso.service;

import br.com.acsp.curso.domain.Agenda;
import br.com.acsp.curso.repository.AgendaRepository;
import org.apache.commons.lang.time.DateUtils;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author pedrosa
 */

@Service
public class AgendaService extends AbstractService<Agenda, Long> {

	@Autowired
    public void setRepository(AgendaRepository repository) {
        super.repository = repository;
    }

    public AgendaRepository getRepository() {
        return (AgendaRepository) repository;
    }

    public Collection<Agenda> obterAgendamentosDoMes(Date dataRef) {
        final Date inicioMes = DateUtils.truncate(dataRef, Calendar.MONTH);
        final Date fimDoMes = DateUtils.addMonths(inicioMes, 1);
        return getRepository().findByDataReservaBetween(inicioMes, fimDoMes);
    }
}
