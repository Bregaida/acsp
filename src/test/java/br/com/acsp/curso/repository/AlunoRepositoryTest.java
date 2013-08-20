package br.com.acsp.curso.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.Assert.assertNotNull;

/**
 * User: Christian Reichel
 * Date: 8/20/13
 * Time: 10:31 PM
 */
public class AlunoRepositoryTest extends AbstractRepositoryTestSupport {

    @Autowired
    private AlunoRepository repository;

    @Test
    public void testListarOrdenadoPorNome() throws Exception {
        assertNotNull(repository);
    }
}
