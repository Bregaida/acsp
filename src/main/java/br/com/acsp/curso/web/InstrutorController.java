/**
 *
 */
package br.com.acsp.curso.web;

import br.com.acsp.curso.domain.EscolaridadeType;
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
	@ResponseBody
	public Instrutor buscaPorId(@PathVariable("id") Long id, ModelMap modelMap) {
		return instrutorService.obtemPorId(id);
	}

	@RequestMapping(value = "/instrutor/{id}", method = RequestMethod.POST)
	public String atualiza(@PathVariable("id") Long id,
			@ModelAttribute("instrutor") Instrutor instrutor) {
		instrutor.setId(id);
		instrutorService.alterar(instrutor);
		return "redirect:/instrutores";
	}

	@RequestMapping(value = "/instrutor", method = RequestMethod.POST)
	public String salvar(@Valid Instrutor instrutor, BindingResult bindingResult, Model uiModel) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("instrutor", instrutor);
            uiModel.addAttribute("instrutoresMenu", "active");
            uiModel.addAttribute("listaDeInstrutores", instrutorService.listarOrdenado());
            uiModel.addAttribute("escolaridades", EscolaridadeType.values());
            return "instrutor/lista";
        }
        uiModel.asMap().clear();
        instrutorService.salvar(instrutor);
        return "redirect:/instrutores";
    }
}
