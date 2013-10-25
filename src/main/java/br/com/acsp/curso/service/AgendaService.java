package br.com.acsp.curso.service;

import br.com.acsp.curso.domain.Aeronave;
import br.com.acsp.curso.domain.Agenda;
import br.com.acsp.curso.domain.Horario;
import br.com.acsp.curso.repository.*;
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

    @Autowired private HorarioRepository horarioRepository;
    @Autowired private AeronaveRepository aeronaveRepository;

    @Autowired
    public void setRepository(AgendaRepository repository) {
        super.repository = repository;
    }

    public Collection<Agenda> obterAgendamentosDoMes(Date dataRef) {
        final Date inicioMes = DateUtils.truncate(dataRef, Calendar.MONTH);
        final Date fimDoMes = DateUtils.addMonths(inicioMes, 1);
        return ((AgendaRepository) repository).findByDataReservaBetween(inicioMes, fimDoMes);
    }

    public Collection<Horario> obterHorariosLivresPorAeronave(Date dataReserva, Long idAeronave) {
        Collection<Horario> horarios = horarioRepository.listarOrdenadoPorId();
        Aeronave aeronave = aeronaveRepository.findOne(idAeronave);
        Collection<Agenda> agendas = ((AgendaRepository) repository).findByDataReservaAndAeronave(dataReserva, aeronave);

        //TODO - Precisa melhorar esta logica. Se um agendamento possui duração de 3h não exclui o proximo horario
        //Esses horarios serão sempre pre-determinados?
        for (Agenda agenda : agendas) {
            if (horarios.contains(agenda.getHorario())) {
                horarios.remove(agenda.getHorario());
            }
        }

        return horarios;
    }

}
