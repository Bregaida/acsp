/**
 *
 */
package br.com.acsp.curso.web;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.acsp.curso.domain.EscolaridadeType;
import br.com.acsp.curso.domain.Instrutor;
import br.com.acsp.curso.service.AeronaveService;
import br.com.acsp.curso.service.InstrutorService;

/**
 * @author pedrosa
 */

@Controller
public class InstrutorController extends AbstractController {

    private static final Log logger = LogFactory
	    .getLog(InstrutorController.class);

    @Autowired
    private InstrutorService instrutorService;

    @Autowired
    private AeronaveService aeronaveService;

    /**
     * Este metodo adiciona o Instrutor ao (form) request, basta usar o form com
     * o nome de "Instrutor"
     * 
     * @return
     */
    @ModelAttribute("instrutor")
    public Instrutor getInstrutor() {
	return new Instrutor();
    }

    @RequestMapping("/instrutores")
    public String lista(ModelMap map) {
	map.put("instrutoresMenu", "active");
	map.put("listaDeInstrutores", instrutorService.listarOrdenado());
	map.put("escolaridades", EscolaridadeType.values());
	map.put("listaDeAeronaves", aeronaveService.listarAtivas());
	return "instrutor/lista";
    }

    @RequestMapping(value = "/instrutores", method = RequestMethod.POST)
    @ResponseBody
    public Collection<Instrutor> listaPorAjax(Pageable pageable) {
	final Page<Instrutor> instrutores = instrutorService
		.pesquisarTodos(pageable);
	logger.info(ToStringBuilder.reflectionToString(instrutores,
		ToStringStyle.MULTI_LINE_STYLE));
	return instrutores.getContent();
    }

    @RequestMapping(value = "/instrutor/{id}/apaga", method = RequestMethod.GET)
    @ResponseBody
    public String exclui(@PathVariable("id") Long id) {
	instrutorService.excluirPorId(id);
	return "SUCCESS";
    }

    @RequestMapping(value = "/instrutor/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Instrutor buscaPorId(@PathVariable("id") Long id, ModelMap modelMap) {
	return instrutorService.obtemPorId(id);
    }

    @RequestMapping(value = "/instrutor", method = RequestMethod.POST)
    public String salvarOuAtualizar(@Valid Instrutor instrutor, BindingResult bindingResult, ModelMap map) {
        if (bindingResult.hasErrors()) {
            map.put("instrutor", instrutor);
            map.put("escolaridades", EscolaridadeType.values());
            return "instrutor/formulario";
        }
        final String msgOperacao = getMensagemOperacao(instrutor.getId());
        instrutorService.salvar(instrutor);
        map.put("msgSucesso", "Instrutor " + instrutor.getNome() + " " + msgOperacao + " com exito.");
        return "success";
    }

    @RequestMapping(value = "/instrutor/disponiveis/{idHora}/{idAeronave}", method = RequestMethod.GET)
    @ResponseBody
    public List<Instrutor> listarInstrutoresDisponiveisPorHoraAeronaveAula(
	    @PathVariable("idHora") Long idHora,
	    @PathVariable("idAeronave") Long idAeronave,
        @RequestParam Date dataReserva) {

        return (List<Instrutor>) instrutorService.listarDisponiveis(idHora, idAeronave, dataReserva);
    }

    @RequestMapping(value = "/instrutor/aeronave", method = RequestMethod.POST)
    public String editarAeronaves(@ModelAttribute("instrutor") Instrutor instrutor, ModelMap map) {
        Instrutor instrutorDB = instrutorService.obtemPorId(instrutor.getId());
        BeanUtils.copyProperties(instrutorDB, instrutor, new String[] { "aeronaves" });
        instrutorService.alterar(instrutor);
        final String msgOperacao = getMensagemOperacao(instrutorDB.getId());
        map.put("msgSucesso", "Instrutor " + instrutorDB.getNome() + " " + msgOperacao + " com exito.");
        return "success";
    }
}
