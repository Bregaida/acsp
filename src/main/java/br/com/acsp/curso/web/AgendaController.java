/**
 *
 */
package br.com.acsp.curso.web;

import br.com.acsp.curso.domain.Agenda;
import br.com.acsp.curso.domain.Aluno;
import br.com.acsp.curso.service.AeronaveService;
import br.com.acsp.curso.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author pedrosa
 */

@Controller
public class AgendaController extends AbstractController {

    @Autowired
    private AgendaService agendaService;

    @Autowired
    private AeronaveService aeronaveService;

    /**
     * Este metodo adiciona a agenda ao (form) request, basta usar o form com o nome de "agenda"
     * @return
     */
    @ModelAttribute("agenda")
    public Agenda getAgenda() {
        return new Agenda();
    }

    @RequestMapping(value = "/agenda", method = RequestMethod.POST)
    public String criaAgendamento(@ModelAttribute("agenda") Agenda agenda) {
        agendaService.salvar(agenda);
        return "redirect:agendas";
    }

    @RequestMapping(value = "/agenda", method = RequestMethod.GET)
    public String preparaForm() {
        return "agenda/formulario";
    }

    @RequestMapping(value = "/agenda/{id}", method = RequestMethod.POST)
    public String atualiza(@PathVariable("id") Long id, @ModelAttribute("agenda") Agenda agenda) {
        agenda.setId(id);
        agendaService.alterar(agenda);
        return "agenda/lista";
    }

    @RequestMapping(value = "/agendas", method = RequestMethod.GET)
    public String lista(ModelMap map) {
        map.put("listaDeAlunos", agendaService.pesquisarTodos());
        return "agenda/lista";
    }
}
