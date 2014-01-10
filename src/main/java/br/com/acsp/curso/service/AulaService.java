/**
 *
 */
package br.com.acsp.curso.service;

import br.com.acsp.curso.domain.Aeronave;
import br.com.acsp.curso.domain.Aula;
import br.com.acsp.curso.repository.AeronaveRepository;
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
    private AeronaveRepository aeronaveRepository;

    @Autowired
    public void setRepository(AulaRepository repository) {
        super.repository = repository;
    }

    public Collection<Aula> listarOrdenado() {
        return ((AulaRepository) repository).listarOrdenadoPorMateria();
    }

    public Collection<Aula> listarAulasPorAeronave(Long idAeronave) {
        Aeronave aeronave = aeronaveRepository.findOne(idAeronave);
        Collection<Aula> aulas = ((AulaRepository) repository).findByAeronavesOrderByMateriaAsc(aeronave);
        return aulas;
    }
}
