/**
 * 
 */
package br.com.acsp.curso.domain.escala;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.acsp.curso.common.AbstractController;

/**
 * @author eduardobregaida
 * 
 */

@Controller
public class EscalaController extends AbstractController {

    @Autowired
    private EscalaService escalaService;

    @ModelAttribute("escala")
    public Escala getEscala() {
	return new Escala();
    }

    @RequestMapping(value = "/escala/spa", method = RequestMethod.GET)
    public String spa(ModelMap map) {
	return "escala/formulario";
    }

    @RequestMapping(value = "/escalas", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Escala> listar(ModelMap map) {
	return escalaService.listarTodos();
    }

    @RequestMapping(value = "/escala", method = RequestMethod.POST)
    public void salvarOuAtualizar(@Valid Escala escala, BindingResult result) {
	validateBindingResult(result);
	escalaService.salvar(escala);
    }

    @RequestMapping(value = "/escala/{id}/apaga", method = RequestMethod.GET)
    @ResponseBody
    public String exclui(@PathVariable("id") String id) {
	escalaService.excluirPorId(id);
	return "SUCCESS";
    }
}
