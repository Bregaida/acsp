package br.com.acsp.curso.anotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.acsp.curso.validation.ReservaValidator;

@Constraint(validatedBy = ReservaValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Reserva {
	String message() default "Data da reserva inválida";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
