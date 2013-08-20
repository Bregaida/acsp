/**
 *
 */
package br.com.acsp.curso.service;

import br.com.acsp.curso.domain.Aula;
import br.com.acsp.curso.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author eduardobregaida
 */

@Service
public class AulaService extends AbstractService<Aula, Long> {

    @Autowired
    public void setRepository(AulaRepository repository) {
        super.repository = repository;
    }

    public Collection<Aula> listarOrdenado() {
        return ((AulaRepository) repository).listarOrdenadoPorMateria();
    }
}
