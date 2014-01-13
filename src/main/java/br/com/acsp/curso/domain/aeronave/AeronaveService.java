/**
 *
 */
package br.com.acsp.curso.domain.aeronave;

import br.com.acsp.curso.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author eduardobregaida
 */

@Service
public class AeronaveService extends AbstractService<Aeronave, String> {

    @Autowired
    public void setRepository(AeronaveRepository aeronaveRepository) {
        super.setRepository(aeronaveRepository);
    }

    public Collection<Aeronave> listarAtivas() {
        return ((AeronaveRepository) getRepository()).findByAtivo(true);
    }

    @Override
    public String getSortAttribute() {
        return "modelo";
    }
}
