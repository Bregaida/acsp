/**
 *
 */
package br.com.acsp.curso.web;

import br.com.acsp.curso.domain.Aluno;
import br.com.acsp.curso.service.AlunoService;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author eduardobregaida
 */

@Controller
public class AlunosController {

    private static final Log logger = LogFactory.getLog(AlunosController.class);

    @Autowired
    private AlunoService alunoService;

    /**
     * Este metodo adiciona o aluno ao (form) request, basta usar o form com o nome de "aluno"
     * @return
     */
    @ModelAttribute("aluno")
    public Aluno getAluno() {
        return new Aluno();
    }

    @RequestMapping("/alunos")
    public String lista(ModelMap map) {
        map.put("listaDeAlunos", alunoService.listarOrdenado());
        return "aluno/lista";
    }

    @RequestMapping(value = "/aluno", method = RequestMethod.GET)
    public String preparaForm() {
        return "aluno/formulario";
    }

    @RequestMapping(value = "/aluno/{id}/apaga", method = RequestMethod.GET)
    public String exclui(@PathVariable("id") Long id) {
        alunoService.excluirPorId(id);
        return "redirect:/alunos";
    }

    @RequestMapping(value = "/aluno/{id}", method = RequestMethod.GET)
    public String buscaPorId(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.put("aluno", alunoService.obtemPorId(id));
        return "aluno/formulario";
    }

    @RequestMapping(value = "/aluno/{id}", method = RequestMethod.POST)
    public String atualiza(@PathVariable("id") Long id, @ModelAttribute("aluno") Aluno aluno) {
        aluno.setId(id);
        alunoService.alterar(aluno);
        return "redirect:/alunos";
    }

    @RequestMapping(value = "/aluno", method = RequestMethod.POST)
    public String salvarAluno(@ModelAttribute("aluno") Aluno aluno) {
        alunoService.salvar(aluno);
        return "redirect:/alunos";
    }
}
