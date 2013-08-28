/**
 *
 */
package br.com.acsp.curso.web;

import br.com.acsp.curso.domain.Agenda;
import br.com.acsp.curso.domain.Horario;
import br.com.acsp.curso.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author pedrosa
 */

@Controller
public class AgendaController extends AbstractController {

	@Autowired private AgendaService agendaService;
	@Autowired private AlunoService alunoService;
	@Autowired private SocioService socioService;
	@Autowired private AeronaveService aeronaveService;
	@Autowired private InstrutorService instrutorService;
	@Autowired private AulaService aulaService;
	@Autowired private HorarioService horarioService;

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

	@RequestMapping(value = "/agenda", method = RequestMethod.POST)
	public String criaAgendamento(@ModelAttribute("agenda") Agenda agenda) {
		agendaService.salvar(agenda);
		return "redirect:/agendas";
	}

	@RequestMapping(value = "/agenda", method = RequestMethod.GET)
	public String preparaForm(ModelMap map) {
		return "agenda/formulario";
	}

	private void mockHorarios() {
		Horario horario = null;
		for (int i = 8; i < 22; i++) {
			horario = new Horario();
			horario.setHorarioAgenda(i < 10 ? "0" + i + ":00" : i + ":00");
			horarioService.salvar(horario);
		}
	}

	@RequestMapping(value = "/agenda/{id}", method = RequestMethod.POST)
	public String atualiza(@PathVariable("id") Long id,
			@ModelAttribute("agenda") Agenda agenda) {
		agenda.setId(id);
		agendaService.alterar(agenda);
		return "redirect:/agendas";
	}

	@RequestMapping(value = "/agenda/{id}/apaga", method = RequestMethod.GET)
	public String exclui(@PathVariable("id") Long id) {
		agendaService.excluirPorId(id);
		return "redirect:/agendas";
	}

	@RequestMapping(value = "/agenda/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Agenda buscaPorId(@PathVariable("id") Long id, ModelMap map) {
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
