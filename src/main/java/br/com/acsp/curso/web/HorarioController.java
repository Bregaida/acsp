/**
 *
 */
package br.com.acsp.curso.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.acsp.curso.domain.Horario;
import br.com.acsp.curso.service.HorarioService;

/**
 * @author pedrosa
 */

@Controller
public class HorarioController extends AbstractController {

	@Autowired
	private HorarioService horarioService;

	// TODO Combo aninhada agenda
	@RequestMapping(value = "/horario/disponiveis/{idAeronave}", method = RequestMethod.GET)
	@ResponseBody
	public List<Horario> listarHorasPorDisponibilidadeAeronave(
			@PathVariable("idAeronave") Long idAeronave) {
		// horarioService.listarHorasPorDisponibilidadeAeronave(idAeronave);
		// System.out.println("Partiu Australia " + idAeronave);
		// Que Sysout é esse? =P

		return (List<Horario>) horarioService.listarOrdenado();
	}

}
