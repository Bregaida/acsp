package br.com.acsp.curso.service;

import br.com.acsp.curso.domain.Agenda;
import br.com.acsp.curso.domain.Horario;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Pedro
 * Date: 29/10/13
 * Time: 21:14
 * To change this template use File | Settings | File Templates.
 */
public class AgendaServiceTest {
    @Test
    public void testObterHorariosLivresPorAeronave() throws Exception {
        for (int i = 1; i < 6; i++) {
            System.out.print(i);
            System.out.print(" | ");
            System.out.print(i/2);
            System.out.print(" | ");
            System.out.print(i%2);
            System.out.print(" | ");
            System.out.println(i/2 + i%2);
        }
    }
}
