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
public class AgendaController extends AbstractController {

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

    @RequestMapping(value = "/agendas", method = RequestMethod.POST)
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
            // TODO: Devera ser listado por horario dispoivel
            mockHorarios();
            model.addAttribute("listaDeHorarios", horarioService.listarOrdenado());
            return "agenda/lista";
        }
        agendaService.salvar(agenda);
        return "redirect:/agendas";
    }

    private void mockHorarios() {
        Horario horario = null;
        for (int i = 8; i < 22; i++) {
            horario = new Horario();
            horario.setHorarioAgenda(i < 10 ? "0" + i + ":00" : i + ":00");
            horarioService.salvar(horario);
        }
    }

    @RequestMapping(value = "/agenda/{id}/apaga", method = RequestMethod.GET)
    @ResponseBody
    public String exclui(@PathVariable("id") Long id) {
        agendaService.excluirPorId(id);
        return "SUCCESS";
    }

    @RequestMapping(value = "/agenda/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Agenda buscaPorId(@PathVariable("id") Long id) {
        return agendaService.obtemPorId(id);
    }

    @RequestMapping(value = "/agendas", method = RequestMethod.GET)
    public String lista(ModelMap map) {
        map.put("agendasMenu", "active");
        map.put("listaDeAgendas", agendaService.pesquisarTodos());
        map.put("listaDeAlunos", alunoService.listarOrdenado());
        map.put("listaDeSocios", socioService.listarOrdenado());
        map.put("listaDeAeronaves", aeronaveService.listarOrdenadoPorModelo());
        map.put("listaDeInstrutores", instrutorService.listarOrdenado());
        map.put("listaDeAulas", aulaService.listarOrdenado());
        // TODO: Devera ser listado por horario dispoivel
        mockHorarios();

        map.put("listaDeHorarios", horarioService.listarOrdenado());

        return "agenda/lista";
    }
}
