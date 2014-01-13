/**
 *
 */
package br.com.acsp.curso.domain.agenda;

import br.com.acsp.curso.common.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author pedrosa
 */

@Controller
public class AgendamentoController extends AbstractController {

    @Autowired
    private AgendaService agendaService;

    /**
     * Este metodo adiciona a agenda ao (form) request, basta usar o form com o
     * nome de "agenda"
     *
     * @return
     */
    @ModelAttribute("agenda")
    public Agenda getAgenda() {
        return new Agenda();
    }

    @RequestMapping(value = "/agendamento/spa", method = RequestMethod.GET)
    public String spa(ModelMap map) {
        return "agenda/formulario";
    }

    @RequestMapping(value = "/agendamentos", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Agenda> listar(ModelMap map) {
        return agendaService.obterAgendamentosDoMes(new Date());
    }

    @RequestMapping(value = "/agenda", method = RequestMethod.GET)
    @ResponseBody
    public Collection<EventDTO> obtemAgendamentosAjax() {
        final Date dataRef = new Date();
        final Collection<Agenda> agendamentos = agendaService
                .obterAgendamentosDoMes(dataRef);
        final Collection<EventDTO> eventos = new ArrayList<EventDTO>();
        for (Agenda agendamento : agendamentos) {
            eventos.add(new EventDTO(agendamento));
        }
        return eventos;
    }

    @RequestMapping(value = "/agendamento", method = RequestMethod.POST)
    public void salvarOuAtualizar(@Valid Agenda agenda, BindingResult result) {
        validateBindingResult(result);
        agendaService.salvar(agenda);
    }

    @RequestMapping(value = "/agendamento/{id}/apaga", method = RequestMethod.GET)
    @ResponseBody
    public String exclui(@PathVariable("id") String id) {
        agendaService.excluirPorId(id);
        return "SUCCESS";
    }

    @RequestMapping(value = "/agendamento/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Agenda buscaPorId(@PathVariable("id") String id) {
        return agendaService.obtemPorId(id);
    }

}
