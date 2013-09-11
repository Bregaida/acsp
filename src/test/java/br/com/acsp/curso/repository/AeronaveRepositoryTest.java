/**
 * 
 */
package br.com.acsp.curso.repository;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author eduardobregaida
 * 
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
		assertTrue(!repository.listarAtivas().isEmpty());
	}
}
