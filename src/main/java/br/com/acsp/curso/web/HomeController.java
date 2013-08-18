package br.com.acsp.curso.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: Christian Reichel
 * Date: 8/18/13
 * Time: 10:44 AM
 */
@Controller
public class HomeController extends AbstractController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
        return "../home"; //TODO: fixx
    }

}
