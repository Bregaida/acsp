package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Agenda;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;

/**
 * User: Christian Reichel
 * Date: 9/1/13
 * Time: 1:05 PM
 */
public class AgendaRepositoryTest {//extends AbstractRepositoryTestSupport {

    @Autowired
    private AgendaRepository repository;

    @Test
    public void testFindByDataReservaDateAfterAndDataReservaBefore() throws Exception {
        //Given
        final Date inicio = DateUtils.round(new Date(), Calendar.MONTH);
        final Date fim = DateUtils.addMonths(inicio, 1);
        System.out.println("inicio " + inicio);
        System.out.println("fim " + fim);
        //When
        //final Collection<Agenda> agendamentos = repository.findByDataReservaBetween(inicio, fim);
        //Then
        //assertEquals(0, agendamentos);
    }
}
