package br.com.acsp.curso.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertNotNull;

/**
 * User: Christian Reichel
 * Date: 8/20/13
 * Time: 10:31 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AlunoRepositoryTest {

    @Autowired
    private AlunoRepository repository;

    @Test
    public void testListarOrdenadoPorNome() throws Exception {
        assertNotNull(repository);
    }
}
