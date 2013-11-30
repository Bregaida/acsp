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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

/**
 * @author eduardobregaida
 */
@Controller
public class AtendenteController extends AbstractController {

    private static final Log logger = LogFactory.getLog(AtendenteController.class);

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

    @RequestMapping("/atendentes/spa")
    public String spa(ModelMap map) {
        return "atendente/lista";
    }

    @RequestMapping("/atendentes")
    @ResponseBody
    public Collection<Atendente> lista(ModelMap map) {
        return atendenteService.listarOrdenado();
    }

    // Nem todos os browser suportam DELETE
    @RequestMapping(value = "/atendente/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void exclui(@PathVariable("id") Long id) {
        atendenteService.excluirPorId(id);
    }

    @RequestMapping(value = "/atendente/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Atendente buscaPorId(@PathVariable("id") Long id) {
        logger.info("AtendenteController: buscaPorId");
        return atendenteService.obtemPorId(id);
    }

    @RequestMapping(value = "/atendente", method = RequestMethod.POST)
    @ResponseBody
    public void salvarOuAtualizar(@Valid Atendente atendente) {
        atendenteService.salvar(atendente);
    }
}
