package br.com.acsp.curso.validation;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.joda.time.DateTime;
import org.joda.time.Days;

import br.com.acsp.curso.anotation.Reserva;

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
		return dias >=0 && dias <= 15;
	}

}
