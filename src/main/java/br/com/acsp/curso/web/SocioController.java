/**
 *
 */
package br.com.acsp.curso.web;

import br.com.acsp.curso.domain.Socio;
import br.com.acsp.curso.service.SocioService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author pedrosa
 */

@Controller
public class SocioController {

	private static final Log logger = LogFactory.getLog(SocioController.class);

	@Autowired
	private SocioService socioService;

	/**
	 * Este metodo adiciona o socio ao (form) request, basta usar o form com o
	 * nome de "socio"
	 * 
	 * @return
	 */
	@ModelAttribute("socio")
	public Socio getSocio() {
		return new Socio();
	}

	@RequestMapping("/socios")
	public String lista(ModelMap map) {
        map.put("sociosMenu", "active");
        map.put("listaDeSocios", socioService.listarOrdenado());
		return "socio/lista";
	}

	@RequestMapping(value = "/socio", method = RequestMethod.GET)
	public String preparaForm() {
		return "socio/formulario";
	}

	@RequestMapping(value = "/socio/{id}/apaga", method = RequestMethod.GET)
	public String exclui(@PathVariable("id") Long id) {
		socioService.excluirPorId(id);
		return "redirect:/socios";
	}

	@RequestMapping(value = "/socio/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Socio buscaPorId(@PathVariable("id") Long id, ModelMap modelMap) {
		return socioService.obtemPorId(id);
	}

	@RequestMapping(value = "/socio/{id}", method = RequestMethod.POST)
	public String atualiza(@PathVariable("id") Long id,
			@ModelAttribute("socio") Socio socio) {
		socio.setId(id);
		socioService.alterar(socio);
		return "redirect:/socios";
	}

	@RequestMapping(value = "/socio", method = RequestMethod.POST)
	public String salvarAluno(@ModelAttribute("socio") Socio socio) {
		socioService.salvar(socio);
		return "redirect:/socios";
	}
}
