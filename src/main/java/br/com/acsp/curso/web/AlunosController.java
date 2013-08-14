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
 *
 */

@Controller
public class AlunosController {

    private static final Log logger = LogFactory.getLog(AlunosController.class);

    @Autowired private AlunoService alunoService;

    @ModelAttribute("aluno")
    public Aluno getPerson(){
        final Aluno aluno = new Aluno();
        aluno.setNome("Bregaida");
        aluno.setCpf(123L);
        aluno.setRg(32L);
        return aluno;
    }

    @RequestMapping("/alunos")
    public String lista(ModelMap map){
        map.put("listaDeAlunos", alunoService.listarOrdenado());
        return "aluno/lista";
    }

    @RequestMapping(value = "/aluno/{id}/apaga", method = RequestMethod.GET)
    public String exclui(@PathVariable("id") Long id){
        alunoService.excluirPorId(id);
        return "redirect:/alunos";
    }

    @RequestMapping(value = "/alunos/adicionar", method = RequestMethod.GET)
    public String adicionaFormAoRequest(){
        return "aluno/formulario";
    }

    @RequestMapping(value = "/alunos/adicionar", method = RequestMethod.POST)
    public String salvarAluno(@ModelAttribute("aluno") Aluno aluno, BindingResult result, HttpServletRequest request){
        Enumeration enAttr = request.getAttributeNames();
        while(enAttr.hasMoreElements()){
            String attributeName = (String)enAttr.nextElement();
            System.out.println("Attribute Name - "+attributeName+", Value - "+(request.getAttribute(attributeName)).toString());
        }
        System.out.println("Salvando controller " + ToStringBuilder.reflectionToString(aluno, ToStringStyle.MULTI_LINE_STYLE));
        alunoService.salvar(aluno);
        return "redirect:/alunos";
    }
}
