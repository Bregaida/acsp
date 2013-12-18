package br.com.acsp.curso.anotation;

import br.com.acsp.curso.validation.ReservaValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = ReservaValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Reserva {
	String message() default "Data da reserva inválida";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
