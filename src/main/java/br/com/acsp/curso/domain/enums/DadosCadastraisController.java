package br.com.acsp.curso.domain.enums;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: chrisreichel
 * Date: 17/11/2013
 * Time: 11:32
 */
@Controller
public class DadosCadastraisController {

    @RequestMapping("/escolaridades")
    @ResponseBody
    public EscolaridadeType[] escolaridades() {
        return EscolaridadeType.values();
    }


}
