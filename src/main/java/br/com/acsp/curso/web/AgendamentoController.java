/**
 *
 */
package br.com.acsp.curso.web;

import br.com.acsp.curso.domain.Agenda;
import br.com.acsp.curso.domain.EventDTO;
import br.com.acsp.curso.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
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
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private SocioService socioService;
    @Autowired
    private AeronaveService aeronaveService;
    @Autowired
    private InstrutorService instrutorService;
    @Autowired
    private AulaService aulaService;
    @Autowired
    private HorarioService horarioService;

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
        formularioMap(map);
        return "agenda/formulario";
    }

    @RequestMapping(value = "/agendamentos", method = RequestMethod.GET)
    public Collection<Agenda> listar(ModelMap map) {
        formularioMap(map);
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
    public String salvarOuAtualizar(@Valid Agenda agenda, BindingResult result,
                                    ModelMap map) {
        if (result.hasErrors()) {
            map.put("agenda", agenda);
            formularioMap(map);
            return "agenda/formulario";
        }
        agendaService.salvar(agenda);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        map.put("msgSucesso",
                "Agendamento para data "
                        + format.format(agenda.getDataReserva())
                        + " realizado com exito.");
        return "success";
    }

    private void formularioMap(ModelMap map) {
        map.put("listaDeAlunos", alunoService.listarAtivos());
        map.put("listaDeSocios", socioService.listarAtivos());
        map.put("listaDeAeronaves", aeronaveService.listarAtivas());
        map.put("listaDeInstrutores", instrutorService.listarAtivos());
        map.put("listaDeAulas", aulaService.listarOrdenado());
        map.put("listaDeHorarios", horarioService.listarOrdenado());

    }

    @RequestMapping(value = "/agendamento/{id}/apaga", method = RequestMethod.GET)
    @ResponseBody
    public String exclui(@PathVariable("id") Long id) {
        agendaService.excluirPorId(id);
        return "SUCCESS";
    }

    @RequestMapping(value = "/agendamento/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Agenda buscaPorId(@PathVariable("id") Long id) {
        return agendaService.obtemPorId(id);
    }

}
