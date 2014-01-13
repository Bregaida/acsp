/**
 *
 */
package br.com.acsp.curso.domain.aeronave;

import br.com.acsp.curso.common.AbstractController;
import br.com.acsp.curso.domain.aluno.Aluno;
import br.com.acsp.curso.domain.aluno.AlunoService;
import br.com.acsp.curso.domain.aula.AulaService;
import br.com.acsp.curso.domain.instrutor.Instrutor;
import br.com.acsp.curso.domain.instrutor.InstrutorService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author eduardobregaida
 */
@Controller
public class AeronaveController extends AbstractController {

    private static final Log logger = LogFactory
            .getLog(AeronaveController.class);

    @Autowired
    private AeronaveService aeronaveService;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private InstrutorService instrutorService;

    @Autowired
    private AulaService aulaService;

    @ModelAttribute("aeronave")
    public Aeronave getAeronave() {
        return new Aeronave();
    }

    @RequestMapping("/aeronaves/spa")
    public String singlePageApp(ModelMap map) {
        return "aeronave/lista";
    }

    @RequestMapping("/aeronaves")
    @ResponseBody
    public Collection<Aeronave> lista(ModelMap map) {
        return aeronaveService.listarOrdenado();
    }

    @RequestMapping(value = "/aeronave/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void exclui(@PathVariable("id") String id) {
        logger.info("AeronaveController: exclui");
        aeronaveService.excluirPorId(id);
    }

    @RequestMapping(value = "/aeronave/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Aeronave buscaPorId(@PathVariable("id") String id, ModelMap modelMap) {
        return aeronaveService.obtemPorId(id);
    }

    @RequestMapping(value = "/aeronave", method = RequestMethod.POST)
    @ResponseBody
    public Aeronave salvarOuAtualizar(@Valid Aeronave aeronave, BindingResult result) {
        validateBindingResult(result);
        aeronaveService.salvar(aeronave);
        return aeronave;
    }

    @RequestMapping(value = "/aeronaves/disponiveis/{idAluno}", method = RequestMethod.GET)
    @ResponseBody
    public List<Aeronave> listarAeronavesDisponiveis(
            @PathVariable("idAluno") String idAluno,
            @RequestParam Date dataReserva) {
        // TODO - Usar a data para excluir aeronaves sem horarios disponiveis
        Aluno aluno = alunoService.obtemPorId(idAluno);
        return aluno.getAeronaves();
    }

    @RequestMapping(value = "/aeronaves/disponiveis/{idInstrutor}", method = RequestMethod.GET)
    @ResponseBody
    public List<Aeronave> listarAeronavesDisponiveisPorInstrutor(
            @PathVariable("idInstrutor") String idInstrutor,
            @RequestParam Date dataReserva) {
        // TODO - Usar a data para excluir aeronaves sem horarios disponiveis
        Instrutor instrutor = instrutorService.obtemPorId(idInstrutor);
        return instrutor.getAeronaves();
    }

    @RequestMapping(value = "/aeronaves/ativas", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Aeronave> listarAeronavesAtivas() {
        return aeronaveService.listarAtivas();
    }

}