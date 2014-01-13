/**
 *
 */
package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.aeronave.AeronaveRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author eduardobregaida
 */
public class AeronaveRepositoryTest extends AbstractRepositoryTestSupport {

    @Autowired
    private AeronaveRepository repository;

    @Test
    public void deveHaverAeronavesCarregadosPorDefault() throws Exception {
        assertNotEquals(0, repository.findAll().size());
    }

    @Test
    public void deveHaverCincoAeronavesCarregadosAtivo() throws Exception {
        assertTrue(!repository.findByAtivo(true).isEmpty());
    }
}
