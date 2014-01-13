package br.com.acsp.curso;

import br.com.acsp.curso.config.PersistenceConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: chrisreichel
 * Date: 11/01/2014
 * Time: 19:44
 */
public class ApplicationConfigTest {
    @Test
    public void bootstrapAppFromJavaConfig() {

        ApplicationContext context = new AnnotationConfigApplicationContext(PersistenceConfig.class);
        assertThat(context, is(notNullValue()));
    }
}
