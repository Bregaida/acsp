/**
 *
 */
package br.com.acsp.curso.service;

import br.com.acsp.curso.domain.Socio;
import br.com.acsp.curso.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author pedrosa
 */

@Service
public class SocioService extends AbstractService<Socio, String> {

    @Autowired
    public void setRepository(SocioRepository repository) {
        super.repository = repository;
    }

    public Collection<Socio> listarAtivos() {
        return ((SocioRepository) repository).findByAtivo(true);
    }

    @Override
    protected String getSortAttribute() {
        return "nome";
    }
}
