package br.com.acsp.curso.web;

import br.com.acsp.curso.domain.Agenda;
import br.com.acsp.curso.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.Date;

/**
 * User: Christian Reichel
 * Date: 8/18/13
 * Time: 10:44 AM
 */
@Controller
public class HomeController extends AbstractController {

    @Autowired
    private AgendaService agendaService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(ModelMap map) {
        map.put("homeMenu", "active");
        return "home";
    }

    @RequestMapping(value = "/sobre", method = RequestMethod.GET)
    public String sobre(ModelMap map) {
        map.put("homeMenu", "active");
        return "sobre";
    }
}
