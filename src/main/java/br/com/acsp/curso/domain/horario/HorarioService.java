/**
 *
 */
package br.com.acsp.curso.domain.horario;

import br.com.acsp.curso.common.AbstractService;
import br.com.acsp.curso.domain.horario.Horario;
import br.com.acsp.curso.domain.horario.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eduardobregaida
 */
@Service
public class HorarioService extends AbstractService<Horario, String> {

    @Autowired
    public void setRepository(HorarioRepository repository) {
        super.setRepository(repository);
    }

    @Override
    public String getSortAttribute() {
        return "horarioAgenda";
    }
}
