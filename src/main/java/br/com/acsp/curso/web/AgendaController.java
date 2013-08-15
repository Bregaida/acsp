/**
 * 
 */
package br.com.acsp.curso.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.acsp.curso.domain.Agenda;
import br.com.acsp.curso.service.AeronaveService;
import br.com.acsp.curso.service.AgendaService;

/**
 * @author pedrosa
 *
 */

@Controller
public class AgendaController extends AbstractController {
    
    @Autowired private AgendaService agendaService;
    @Autowired private AeronaveService aeronaveService;

    @RequestMapping(value = "/agenda/adicionar", method = RequestMethod.GET)
    public String adicionaFormAoRequest(ModelMap map,@ModelAttribute("agenda") Agenda agenda){
        //map.put("listaDeAlunos", agendaService.listarOrdenado());
        return "agenda/formulario";
    }
    
    @RequestMapping("/agenda/adicionar")
    public String salvarAgenda(ModelMap map){
        //map.put("listaDeAlunos", agendaService.listarOrdenado());
        return "agenda/lista";
    }

    

}
