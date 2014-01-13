/**
 *
 */
package br.com.acsp.curso.domain.instrutor;

import br.com.acsp.curso.common.AbstractPessoaService;
import br.com.acsp.curso.common.PessoaQueryRespository;
import br.com.acsp.curso.domain.aeronave.Aeronave;
import br.com.acsp.curso.domain.aeronave.AeronaveRepository;
import br.com.acsp.curso.domain.agenda.Agenda;
import br.com.acsp.curso.domain.agenda.AgendaRepository;
import br.com.acsp.curso.domain.horario.Horario;
import br.com.acsp.curso.domain.horario.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author eduardobregaida
 */

@Service
public class InstrutorService extends AbstractPessoaService<Instrutor, String> {

    @Autowired
    private AeronaveRepository aeronaveRepository;

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    public void setRepository(InstrutorRepository repository) {
        super.setRepository(repository);
    }

    @Autowired
    @Override
    public void setQueryRespository(PessoaQueryRespository<Instrutor, String> pessoaQueryRespository) {
        super.setQueryRespository(pessoaQueryRespository);
        super.setType(Instrutor.class);
    }

    public Collection<Instrutor> listarDisponiveis(String idHora, String idAeronave, Date dataReserva) {
        Horario horario = horarioRepository.findOne(idHora);
        Collection<Agenda> agendaCollection = agendaRepository.findByDataReservaAndHorario(dataReserva, horario);

        Aeronave aeronave = aeronaveRepository.findOne(idAeronave);
        Collection<Aeronave> aeronaves = new ArrayList<>();
        aeronaves.add(aeronave);
        Collection<Instrutor> instrutors = ((InstrutorRepository) getRepository()).findByAeronaves(aeronaves);

        for (Agenda agenda : agendaCollection) {
            instrutors.remove(agenda.getInstrutor());
        }

        return instrutors;
    }
}
