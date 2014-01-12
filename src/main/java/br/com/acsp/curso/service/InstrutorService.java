/**
 *
 */
package br.com.acsp.curso.service;

import br.com.acsp.curso.domain.Aeronave;
import br.com.acsp.curso.domain.Agenda;
import br.com.acsp.curso.domain.Horario;
import br.com.acsp.curso.domain.Instrutor;
import br.com.acsp.curso.repository.AeronaveRepository;
import br.com.acsp.curso.repository.AgendaRepository;
import br.com.acsp.curso.repository.HorarioRepository;
import br.com.acsp.curso.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author eduardobregaida
 */

@Service
public class InstrutorService extends AbstractService<Instrutor, String> {

    @Autowired
    private AeronaveRepository aeronaveRepository;

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    public void setRepository(InstrutorRepository repository) {
        super.repository = repository;
    }

    public Collection<Instrutor> listarOrdenado() {
        final Sort sort = new Sort("nome");
        return ((InstrutorRepository) repository).findAll(sort);
    }

    @Override
    protected String getSortAttribute() {
        return "nome";
    }

    public Collection<Instrutor> listarAtivos() {
        return ((InstrutorRepository) repository).findByAtivo(true);
    }

    public Collection<Instrutor> listarDisponiveis(String idHora, String idAeronave, Date dataReserva) {
        Horario horario = horarioRepository.findOne(idHora);
        Collection<Agenda> agendaCollection = agendaRepository.findByDataReservaAndHorario(dataReserva, horario);

        Aeronave aeronave = aeronaveRepository.findOne(idAeronave);
        Collection<Aeronave> aeronaves = new ArrayList<>();
        aeronaves.add(aeronave);
        Collection<Instrutor> instrutors = ((InstrutorRepository) repository).findByAeronaves(aeronaves);

        for (Agenda agenda : agendaCollection) {
            instrutors.remove(agenda.getInstrutor());
        }

        return instrutors;
    }
}
