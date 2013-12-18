package br.com.acsp.curso.web;

import br.com.acsp.curso.domain.EscolaridadeType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: chrisreichel
 * Date: 17/11/2013
 * Time: 11:32
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class DadosCadastraisController {

    @RequestMapping("/escolaridades")
    @ResponseBody
    public EscolaridadeType[] escolaridades(){
        return EscolaridadeType.values();
    }



}
