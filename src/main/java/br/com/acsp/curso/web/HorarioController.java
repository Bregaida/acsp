/**
 *
 */
package br.com.acsp.curso.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.acsp.curso.domain.Horario;

/**
 * @author pedrosa
 */

@Controller
public class HorarioController extends AbstractController {
	
	// TODO Combo aninhada agenda
	@RequestMapping(value = "/horasDisponiveis/{idAeronave}", method = RequestMethod.GET)
	@ResponseBody
	public List<Horario> listarAeronavesDisponiveis(@PathVariable("idAeronave") Long idAeronave) {
		return null;
	}

}
