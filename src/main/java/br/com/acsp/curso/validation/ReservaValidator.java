package br.com.acsp.curso.validation;

import br.com.acsp.curso.anotation.Reserva;
import org.joda.time.DateTime;
import org.joda.time.Days;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

/*
 * @author pedrosa
 */
public class ReservaValidator implements ConstraintValidator<Reserva, Date> {


    @Override
    public void initialize(Reserva constraintAnnotation) {

    }

    @Override
    public boolean isValid(Date dataReserva, ConstraintValidatorContext context) {
        DateTime dataHoje = new DateTime();
        DateTime dataFinal = new DateTime(dataReserva);
        int dias = Days.daysBetween(dataHoje, dataFinal).getDays();
        return dias >= 0 && dias <= 15;
    }

}
