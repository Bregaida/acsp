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

import br.com.acsp.curso.domain.Aeronave;
import br.com.acsp.curso.service.AeronaveService;

/**
 * @author eduardobregaida
 * 
 */
@Controller
public class AeronaveController {

	private static final Log logger = LogFactory
			.getLog(AeronaveController.class);

	@Autowired
	private AeronaveService aeronaveService;

	@ModelAttribute("aeronave")
	public Aeronave getAeronave() {
		return new Aeronave();
	}

	@RequestMapping("/aeronaves")
	public String lista(ModelMap map) {
		logger.info("AeronaveController: lista");
		map.put("listaDeAronaves", aeronaveService.listarOrdenadoPorModelo());
		return "aeronave/lista";
	}

	@RequestMapping(value = "/aeronave", method = RequestMethod.GET)
	public String preparaForm() {
		return "aeronave/formulario";
	}

	@RequestMapping(value = "/aeronave/{id}/apaga", method = RequestMethod.GET)
	public String exclui(@PathVariable("id") Long id) {
		logger.info("AeronaveController: exclui");
		aeronaveService.excluirPorId(id);
		return "redirect:/aeronaves";
	}

	@RequestMapping(value = "/aeronave/{id}", method = RequestMethod.GET)
	public String buscaPorId(@PathVariable("id") Long id, ModelMap modelMap) {
		logger.info("AeronaveController: buscaPorId");
		modelMap.put("aeronave", aeronaveService.obtemPorId(id));
		return "aeronave/formulario";
	}

	@RequestMapping(value = "/aeronave/{id}", method = RequestMethod.POST)
	public String atualiza(@PathVariable("id") Long id,
			@ModelAttribute("aeronave") Aeronave aeronave) {
		logger.info("AeronaveController: atualiza");
		aeronave.setId(id);
		aeronaveService.alterar(aeronave);
		return "redirect:/aeronaves";
	}

	@RequestMapping(value = "/aeronave", method = RequestMethod.POST)
	public String salvar(@ModelAttribute("aeronave") Aeronave aeronave) {
		logger.info("AeronaveController: salva");
		aeronaveService.salvar(aeronave);
		return "redirect:/aeronaves";
	}

}
