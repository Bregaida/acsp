/**
 *
 */
package br.com.acsp.curso.web;

import java.util.List;

import br.com.acsp.curso.domain.EscolaridadeType;
import br.com.acsp.curso.domain.Horario;
import br.com.acsp.curso.domain.Instrutor;
import br.com.acsp.curso.service.InstrutorService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
public class InstrutorController extends AbstractController {

	private static final Log logger = LogFactory
			.getLog(InstrutorController.class);

	@Autowired
	private InstrutorService instrutorService;

	/**
	 * Este metodo adiciona o Instrutor ao (form) request, basta usar o form com
	 * o nome de "Instrutor"
	 * 
	 * @return
	 */
	@ModelAttribute("instrutor")
	public Instrutor getInstrutor() {
		return new Instrutor();
	}

	@RequestMapping("/instrutores")
	public String lista(ModelMap map) {
		map.put("instrutoresMenu", "active");
		map.put("listaDeInstrutores", instrutorService.listarOrdenado());
		map.put("escolaridades", EscolaridadeType.values());
		return "instrutor/lista";
	}

	@RequestMapping(value = "/instrutor/{id}/apaga", method = RequestMethod.GET)
	@ResponseBody
	public String exclui(@PathVariable("id") Long id) {
		instrutorService.excluirPorId(id);
		return "SUCCESS";
	}

	@RequestMapping(value = "/instrutor/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Instrutor buscaPorId(@PathVariable("id") Long id, ModelMap modelMap) {
		return instrutorService.obtemPorId(id);
	}

	@RequestMapping(value = "/instrutor", method = RequestMethod.POST)
	public String salvarOuAtualizar(@Valid Instrutor instrutor,
			BindingResult bindingResult, ModelMap map) {
		if (bindingResult.hasErrors()) {
			map.put("instrutor", instrutor);
			map.put("escolaridades", EscolaridadeType.values());
			return "instrutor/formulario";
		}
		instrutorService.salvar(instrutor);
		map.put("msgSucesso", "Instrutor " + instrutor.getNome() + " inserido com exito.");
		return "success";
	}

	// TODO Combo aninhada agenda
	@RequestMapping(value = "/instrutoresDisponiveis/{idHora}/{idAeronave}/{idAula}", method = RequestMethod.GET)
	@ResponseBody
	public List<Instrutor> listarInstrutoresDisponiveisPorHoraAeronaveAula(@PathVariable("idHora") Long idHora,@PathVariable("idAeronave") Long idAeronave,@PathVariable("idAula") Long idAula) {
		return null;
	}

}
