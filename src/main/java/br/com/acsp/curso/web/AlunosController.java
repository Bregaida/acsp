/**
 *
 */
package br.com.acsp.curso.web;

import br.com.acsp.curso.domain.Aluno;
import br.com.acsp.curso.service.AeronaveService;
import br.com.acsp.curso.service.AlunoService;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

/**
 * @author Christian Reichel
 */

@Controller
public class AlunosController extends AbstractController {

    private static final Log logger = LogFactory.getLog(AlunosController.class);

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private AeronaveService aeronaveService;

    /**
     * Este metodo adiciona o aluno ao (form) request, basta usar o form com o
     * nome de "aluno"
     *
     * @return
     */
    @ModelAttribute("aluno")
    public Aluno getAluno() {
        return new Aluno();
    }

    @RequestMapping(value = "/alunos/spa", method = RequestMethod.GET)
    public String spa(ModelMap map) {
        return "aluno/lista";
    }

    @RequestMapping(value = "/alunos", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Aluno> lista(ModelMap map) {
        return alunoService.listarOrdenado();
    }

    @RequestMapping(value = "/alunos", method = RequestMethod.POST)
    @ResponseBody
    public Collection<Aluno> listaPorAjax(Pageable pageable) {
        final Page<Aluno> alunos = alunoService.pesquisarTodos(pageable);
        logger.info(ToStringBuilder.reflectionToString(alunos, ToStringStyle.MULTI_LINE_STYLE));
        return alunos.getContent();
    }

    // Nem todos os browser suportam DELETE
    @RequestMapping(value = "/aluno/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String exclui(@PathVariable("id") Long id) {
        alunoService.excluirPorId(id);
        return "SUCCESS";
    }

    @RequestMapping(value = "/aluno/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Aluno buscaPorId(@PathVariable("id") Long id) {
        return alunoService.obtemPorId(id);
    }

    @RequestMapping(value = "/aluno", method = RequestMethod.POST)
    public void salvarOuAtualizar(@Valid Aluno aluno, BindingResult result) {
        validateBindingResult(result);
        alunoService.salvar(aluno);
    }

    @RequestMapping(value = "/aluno/aeronave", method = RequestMethod.POST)
    public void editarAeronaves(@ModelAttribute("aluno") Aluno aluno, ModelMap map) {
        Aluno alunoDB = alunoService.obtemPorId(aluno.getId());
        BeanUtils.copyProperties(alunoDB, aluno, new String[]{"aeronaves"});
        alunoService.alterar(aluno);
    }
}
