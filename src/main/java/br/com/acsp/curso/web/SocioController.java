/**
 *
 */
package br.com.acsp.curso.web;

import br.com.acsp.curso.domain.EscolaridadeType;
import br.com.acsp.curso.domain.Socio;
import br.com.acsp.curso.service.AeronaveService;
import br.com.acsp.curso.service.SocioService;
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
public class SocioController extends AbstractController {

	private static final Log logger = LogFactory.getLog(SocioController.class);

	@Autowired
	private SocioService socioService;

	@Autowired
	private AeronaveService aeronaveService;

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
		map.put("escolaridades", EscolaridadeType.values());
		return "socio/lista";
	}

	// Nem todos os browser suportam DELETE
	@RequestMapping(value = "/socio/{id}/apaga", method = RequestMethod.GET)
    @ResponseBody
	public String exclui(@PathVariable("id") Long id) {
		socioService.excluirPorId(id);
		return "SUCCESS";
	}

	@RequestMapping(value = "/socio/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Socio buscaPorId(@PathVariable("id") Long id) {
		return socioService.obtemPorId(id);
	}

	@RequestMapping(value = "/socio", method = RequestMethod.POST)
	public String salvarOuAtualizar(@Valid Socio socio, BindingResult result, ModelMap map) {
        if (result.hasErrors()) {
            map.put("socio", socio);
            map.put("escolaridades", EscolaridadeType.values());
            return "socio/formulario";
        }
        socioService.salvar(socio);
        map.put("msgSucesso", "Socio " + socio.getNome() + " inserido com exito.");
        return "success";
    }
}