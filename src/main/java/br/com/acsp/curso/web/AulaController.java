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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

/**
 * @author pedrosa
 */

@Controller
public class AulaController extends AbstractController {

    private static final Log logger = LogFactory.getLog(AulaController.class);

    @Autowired
    private AulaService aulaService;
    @Autowired
    private AeronaveService aeronaveService;

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

    @RequestMapping(value = "/aulas", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Aula> lista() {
        return aulaService.listarOrdenado();
    }

    @RequestMapping("/aulas/spa")
    public String spa() {
        return "aula/lista";
    }

    @RequestMapping(value = "/aula/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String exclui(@PathVariable("id") Long id) {
        aulaService.excluirPorId(id);
        return "SUCCESS";
    }

    @RequestMapping(value = "/aula/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Aula buscaPorId(@PathVariable("id") Long id) {
        return aulaService.obtemPorId(id);
    }

    @RequestMapping(value = "/aula", method = RequestMethod.POST)
    @ResponseBody
    public void salvarAula(@Valid Aula aula) {
        aulaService.salvar(aula);
    }
}
