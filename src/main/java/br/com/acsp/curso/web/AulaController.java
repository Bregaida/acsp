/**
 *
 */
package br.com.acsp.curso.web;

import br.com.acsp.curso.domain.Aula;
import br.com.acsp.curso.service.AeronaveService;
import br.com.acsp.curso.service.AulaService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author pedrosa
 */

@Controller
public class AulaController extends AbstractController {

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
        map.put("aulasMenu", "active");
		map.put("listaDeAulas", aulaService.listarOrdenado());
		map.put("listaDeAeronaves",aeronaveService.listarOrdenadoPorModelo());
		return "aula/lista";
	}

	@RequestMapping(value = "/aula/{id}/apaga", method = RequestMethod.GET)
    @ResponseBody
	public String exclui(@PathVariable("id") Long id) {
		aulaService.excluirPorId(id);
		return "SUCCESS";
	}

	@RequestMapping(value = "/aula/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Aula buscaPorId(@PathVariable("id") Long id) {
		return aulaService.getByIdDetached(id);
	}

	@RequestMapping(value = "/aula", method = RequestMethod.POST)
	public String salvarAula(@Valid Aula aula, BindingResult result, ModelMap map) {
        if (result.hasErrors()) {
            map.put("hasErrors", true);
            map.put("aula", aula);
            map.put("aulasMenu", "active");
            map.put("listaDeAulas", aulaService.listarOrdenado());
            map.put("listaDeAeronaves", aeronaveService.listarOrdenadoPorModelo());
            return "aula/lista";
        }
        aulaService.salvar(aula);
        return "redirect:/aulas";
    }
}
