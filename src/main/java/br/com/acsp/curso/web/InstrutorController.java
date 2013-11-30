/**
 *
 */
package br.com.acsp.curso.web;

import br.com.acsp.curso.domain.Instrutor;
import br.com.acsp.curso.service.InstrutorService;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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

    @RequestMapping("/instrutores/spa")
    public String singlePageApp() {
        return "instrutor/lista";
    }

    @RequestMapping("/instrutores")
    @ResponseBody
    public Collection<Instrutor> listar(ModelMap map) {
        return instrutorService.listarOrdenado();
    }

    @RequestMapping(value = "/instrutores", method = RequestMethod.POST)
    @ResponseBody
    public Collection<Instrutor> listaPorAjax(Pageable pageable) {
        final Page<Instrutor> instrutores = instrutorService
                .pesquisarTodos(pageable);
        logger.info(ToStringBuilder.reflectionToString(instrutores,
                ToStringStyle.MULTI_LINE_STYLE));
        return instrutores.getContent();
    }

    @RequestMapping(value = "/instrutor/{id}/apaga", method = RequestMethod.GET)
    public void exclui(@PathVariable("id") Long id) {
        instrutorService.excluirPorId(id);
    }

    @RequestMapping(value = "/instrutor/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Instrutor buscaPorId(@PathVariable("id") Long id, ModelMap modelMap) {
        return instrutorService.obtemPorId(id);
    }

    @RequestMapping(value = "/instrutor", method = RequestMethod.POST)
    public void salvarOuAtualizar(@Valid Instrutor instrutor) {
        instrutorService.salvar(instrutor);
    }

    @RequestMapping(value = "/instrutor/disponiveis/{idHora}/{idAeronave}/{idAula}", method = RequestMethod.GET)
    @ResponseBody
    public List<Instrutor> listarInstrutoresDisponiveisPorHoraAeronaveAula(
            @PathVariable("idHora") Long idHora,
            @PathVariable("idAeronave") Long idAeronave,
            @PathVariable("idAula") Long idAula, @RequestParam Date dataReserva) {
        // TODO chamar o metodo certo
        return (List<Instrutor>) instrutorService.listarOrdenado();
    }

    @RequestMapping(value = "/instrutor/aeronave", method = RequestMethod.POST)
    public String editarAeronaves(
            @ModelAttribute("instrutor") Instrutor instrutor, ModelMap map) {
        Instrutor instrutorDB = instrutorService.obtemPorId(instrutor.getId());
        BeanUtils.copyProperties(instrutorDB, instrutor,
                new String[]{"aeronaves"});
        instrutorService.alterar(instrutor);
        return "success";
    }
}
