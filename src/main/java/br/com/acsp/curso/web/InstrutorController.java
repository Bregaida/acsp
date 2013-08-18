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

import br.com.acsp.curso.domain.Instrutor;
import br.com.acsp.curso.service.InstrutorService;

/**
 * @author pedrosa
 */

@Controller
public class InstrutorController {

	private static final Log logger = LogFactory.getLog(InstrutorController.class);

	@Autowired
	private InstrutorService instrutorService;

	/**
	 * Este metodo adiciona o Instrutor ao (form) request, basta usar o form com o
	 * nome de "Instrutor"
	 * 
	 * @return
	 */
	@ModelAttribute("instrutor")
	public Instrutor getInstrutor() {
		return new Instrutor();
	}

	@RequestMapping("/instrutores")
	public String lista(ModelMap map) {
		map.put("listaDeInstrutores", instrutorService.listarOrdenado());
		return "instrutor/lista";
	}

	@RequestMapping(value = "/instrutor", method = RequestMethod.GET)
	public String preparaForm() {
		return "instrutor/formulario";
	}

	@RequestMapping(value = "/instrutor/{id}/apaga", method = RequestMethod.GET)
	public String exclui(@PathVariable("id") Long id) {
		instrutorService.excluirPorId(id);
		return "redirect:/instrutores";
	}

	@RequestMapping(value = "/instrutor/{id}", method = RequestMethod.GET)
	public String buscaPorId(@PathVariable("id") Long id, ModelMap modelMap) {
		modelMap.put("instrutor", instrutorService.obtemPorId(id));
		return "instrutor/formulario";
	}

	@RequestMapping(value = "/instrutor/{id}", method = RequestMethod.POST)
	public String atualiza(@PathVariable("id") Long id,
			@ModelAttribute("instrutor") Instrutor instrutor) {
		instrutor.setId(id);
		instrutorService.alterar(instrutor);
		return "redirect:/instrutores";
	}

	@RequestMapping(value = "/instrutor", method = RequestMethod.POST)
	public String salvarAluno(@ModelAttribute("instrutor") Instrutor instrutor) {
		instrutorService.salvar(instrutor);
		return "redirect:/instrutores";
	}
}
