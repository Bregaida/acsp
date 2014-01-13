package br.com.acsp.curso.domain.pessoa;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: Christian Reichel
 * Date: 8/30/13
 * Time: 9:20 PM
 */
@Controller
public class PessoaController {

    private static final Log logger = LogFactory.getLog(PessoaController.class);

    @Autowired
    private PessoaService pessoaService;

    @RequestMapping(value = "/pessoa/{cpf}", method = RequestMethod.GET)
    @ResponseBody
    public Pessoa buscaPorCPF(@PathVariable("cpf") String cpf) {
        logger.info("PessoaController: buscaPorCPF");
        return pessoaService.obtemPorCPF(cpf);
    }
}
