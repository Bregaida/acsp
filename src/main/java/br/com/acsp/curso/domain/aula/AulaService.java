/**
 *
 */
package br.com.acsp.curso.domain.aula;

import br.com.acsp.curso.common.AbstractService;
import br.com.acsp.curso.domain.aula.Aula;
import br.com.acsp.curso.domain.aeronave.AeronaveRepository;
import br.com.acsp.curso.domain.aula.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eduardobregaida
 */

@Service
public class AulaService extends AbstractService<Aula, String> {

    @Autowired
    private AeronaveRepository aeronaveRepository;

    @Autowired
    public void setRepository(AulaRepository repository) {
        super.setRepository(repository);
    }

    @Override
    public String getSortAttribute() {
        return "materia";
    }
}
