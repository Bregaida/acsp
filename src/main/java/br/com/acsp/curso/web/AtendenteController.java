/**
 * 
 */
package br.com.acsp.curso.web;

import br.com.acsp.curso.domain.Atendente;
import br.com.acsp.curso.domain.EscolaridadeType;
import br.com.acsp.curso.service.AtendenteService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author eduardobregaida
 * 
 */
@Controller
public class AtendenteController extends AbstractController {
	private static final Log logger = LogFactory
			.getLog(AtendenteController.class);

	@Autowired
	private AtendenteService atendenteService;

	/**
	 * Este metodo adiciona o atendente ao (form) request, basta usar o form com
	 * o nome de "atendente"
	 * 
	 * @return
	 */
	@ModelAttribute("atendente")
	public Atendente getAtendente() {
		return new Atendente();
	}

	@RequestMapping("/atendentes")
	public String lista(ModelMap map) {
		logger.info("AtendenteController: lista");
		map.put("atendentesMenu", "active");
		map.put("listaDeAtendentes", atendenteService.listarOrdenado());
		map.put("escolaridades", EscolaridadeType.values());
		return "atendente/lista";
	}

	@RequestMapping(value = "/atendente", method = RequestMethod.GET)
	public String preparaForm() {
		return "atendente/formulario";
	}

	// Nem todos os browser suportam DELETE
	@RequestMapping(value = "/atendente/{id}/apaga", method = RequestMethod.GET)
	public String exclui(@PathVariable("id") Long id) {
		logger.info("AtendenteController: exclui");
		atendenteService.excluirPorId(id);
		return "redirect:/atendentes";
	}

	@RequestMapping(value = "/atendente/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Atendente buscaPorId(@PathVariable("id") Long id, ModelMap modelMap) {
		logger.info("AtendenteController: buscaPorId");
		return atendenteService.obtemPorId(id);
	}

	@RequestMapping(value = "/atendente/{id}", method = RequestMethod.POST)
	public String atualiza(@PathVariable("id") Long id,
			@ModelAttribute("atendente") Atendente atendente) {
		logger.info("AtendenteController: atualiza");
		atendente.setId(id);
		atendenteService.alterar(atendente);
		return "redirect:/atendentes";
	}

	@RequestMapping(value = "/atendente", method = RequestMethod.POST)
	public String salvarAtendente(
			@ModelAttribute("atendente") Atendente atendente) {
		logger.info("AtendenteController: salva");
		atendenteService.salvar(atendente);
		return "redirect:/atendentes";
	}
}
