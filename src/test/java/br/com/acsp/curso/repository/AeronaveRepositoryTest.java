/**
 * 
 */
package br.com.acsp.curso.repository;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
		assertNotNull(repository);
		assertNotEquals(0, repository.findAll().size());
	}

	@Test
	public void deveHaverCincoAeronavesCarregadosAtivo() throws Exception {
		assertNotNull(repository);
		assertEquals(5, repository.listarAtivas().size());
	}
}
