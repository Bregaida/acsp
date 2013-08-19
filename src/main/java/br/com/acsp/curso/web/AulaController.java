/**
 *
 */
package br.com.acsp.curso.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.acsp.curso.domain.Aula;
import br.com.acsp.curso.service.AeronaveService;
import br.com.acsp.curso.service.AulaService;

/**
 * @author pedrosa
 */

@Controller
public class AulaController {

	private static final Log logger = LogFactory.getLog(AulaController.class);

	@Autowired private AulaService aulaService;
	@Autowired private AeronaveService aeronaveService;
	

	/**
	 * Este metodo adiciona a aula ao (form) request, basta usar o form com o
	 * nome da "aula"
	 * 
	 * @return
	 */
	@ModelAttribute("aula")
	public Aula getAula() {
		return new Aula();
	}

	@RequestMapping("/aulas")
	public String lista(ModelMap map) {
		map.put("listaDeAulas", aulaService.listarOrdenado());
		return "aula/lista";
	}

	@RequestMapping(value = "/aula", method = RequestMethod.GET)
	public String preparaForm(ModelMap map) {
		map.put("listaDeAeronaves", aeronaveService.listarOrdenadoPorModelo());
		return "aula/formulario";
	}

	@RequestMapping(value = "/aula/{id}/apaga", method = RequestMethod.GET)
	public String exclui(@PathVariable("id") Long id) {
		aulaService.excluirPorId(id);
		return "redirect:/aulas";
	}

	@RequestMapping(value = "/aula/{id}", method = RequestMethod.GET)
	public String buscaPorId(@PathVariable("id") Long id, ModelMap modelMap) {
		modelMap.put("aula", aulaService.obtemPorId(id));
		modelMap.put("listaDeAeronaves", aeronaveService.listarOrdenadoPorModelo());
		return "aula/formulario";
	}

	@RequestMapping(value = "/aula/{id}", method = RequestMethod.POST)
	public String atualiza(@PathVariable("id") Long id,
			@ModelAttribute("aula") Aula aula) {
		aula.setId(id);
		aulaService.alterar(aula);
		return "redirect:/aulas";
	}

	@RequestMapping(value = "/aula", method = RequestMethod.POST)
	public String salvarAula(@ModelAttribute("aula") Aula aula) {
		aulaService.salvar(aula);
		return "redirect:/aulas";
	}
}
