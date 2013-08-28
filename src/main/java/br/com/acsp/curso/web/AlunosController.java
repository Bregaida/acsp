/**
 *
 */
package br.com.acsp.curso.web;

import br.com.acsp.curso.domain.Aluno;
import br.com.acsp.curso.domain.EscolaridadeType;
import br.com.acsp.curso.service.AlunoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Christian Reichel
 */

@Controller
public class AlunosController extends AbstractController {

    private static final Log logger = LogFactory.getLog(AlunosController.class);

    @Autowired
    private AlunoService alunoService;

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

    @RequestMapping("/alunos")
    public String lista(ModelMap map) {
        map.put("alunosMenu", "active");
        map.put("listaDeAlunos", alunoService.listarOrdenado());
        map.put("escolaridades", EscolaridadeType.values());
        return "aluno/lista";
    }

    // Nem todos os browser suportam DELETE
    @RequestMapping(value = "/aluno/{id}/apaga", method = RequestMethod.GET)
    public String exclui(@PathVariable("id") Long id) {
        alunoService.excluirPorId(id);
        return "redirect:/alunos";
    }

    @RequestMapping(value = "/aluno/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Aluno buscaPorId(@PathVariable("id") Long id) {
        return alunoService.obtemPorId(id);
    }

    @RequestMapping(value = "/alunos", method = RequestMethod.POST)
    public String salvarOuAtualizar(@Valid Aluno aluno, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("formHasError", true);
            model.addAttribute("aluno", aluno);
            model.addAttribute("alunosMenu", "active");
            model.addAttribute("listaDeAlunos", alunoService.listarOrdenado());
            model.addAttribute("escolaridades", EscolaridadeType.values());
            return "aluno/lista";
        }
        alunoService.salvar(aluno);
        return "redirect:/alunos";
    }
}
