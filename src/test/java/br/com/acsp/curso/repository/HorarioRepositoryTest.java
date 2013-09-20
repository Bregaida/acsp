/**
 * 
 */
package br.com.acsp.curso.repository;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author eduardobregaida
 * 
 */
public class HorarioRepositoryTest extends AbstractRepositoryTestSupport {

    @Autowired
    private HorarioRepository repository;

    // @Test
    // TODO: Testar melhor esta query
    public void deveTrazerTodosHorariosDisponiveisDasAeronaves()
	    throws Exception {
	assertNotNull(repository);
	assertEquals(33,
		repository.listarHorariosDisponieisPorAeronave(3L, new Date()));
    }
}
