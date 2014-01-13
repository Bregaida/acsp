/**
 *
 */
package br.com.acsp.curso.domain.horario;

import br.com.acsp.curso.common.AbstractController;
import br.com.acsp.curso.domain.agenda.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author pedrosa
 */

@Controller
public class HorarioController extends AbstractController {

    @Autowired
    private AgendaService agendaService;

    @RequestMapping(value = "/horario/disponiveis/{idAeronave}", method = RequestMethod.GET)
    @ResponseBody
    public List<Horario> listarHorasPorDisponibilidadeAeronave(@PathVariable("idAeronave") String idAeronave, @RequestParam Date dataReserva) {
        return (List<Horario>) agendaService.obterHorariosLivresPorAeronave(dataReserva, idAeronave);
    }

}
