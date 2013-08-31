/**
 *
 */
package br.com.acsp.curso.web;

import br.com.acsp.curso.domain.Agenda;
import br.com.acsp.curso.domain.Horario;
import br.com.acsp.curso.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @RequestMapping(value = "/agendamento", method = RequestMethod.POST)
    public String salvarOuAtualizar(@Valid Agenda agenda, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("formHasError", true);
            model.addAttribute("agendasMenu", "active");
            model.addAttribute("listaDeAgendas", agendaService.pesquisarTodos());
            model.addAttribute("listaDeAlunos", alunoService.listarOrdenado());
            model.addAttribute("listaDeSocios", socioService.listarOrdenado());
            model.addAttribute("listaDeAeronaves", aeronaveService.listarOrdenadoPorModelo());
            model.addAttribute("listaDeInstrutores", instrutorService.listarOrdenado());
            model.addAttribute("listaDeAulas", aulaService.listarOrdenado());
            model.addAttribute("listaDeHorarios", horarioService.listarOrdenado());
            return "agenda/lista";
        }
        agendaService.salvar(agenda);
        return "redirect:/agendamentos";
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

    @RequestMapping(value = "/agendamentos", method = RequestMethod.GET)
    public String lista(ModelMap map) {
        map.put("agendasMenu", "active");
        map.put("listaDeAgendas", agendaService.pesquisarTodos());
        map.put("listaDeAlunos", alunoService.listarOrdenado());
        map.put("listaDeSocios", socioService.listarOrdenado());
        map.put("listaDeAeronaves", aeronaveService.listarOrdenadoPorModelo());
        map.put("listaDeInstrutores", instrutorService.listarOrdenado());
        map.put("listaDeAulas", aulaService.listarOrdenado());
        map.put("listaDeHorarios", horarioService.listarOrdenado());
        return "agenda/lista";
    }
}