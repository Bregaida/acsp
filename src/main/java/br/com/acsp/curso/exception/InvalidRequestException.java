package br.com.acsp.curso.exception;

import org.springframework.validation.Errors;

/**
 * Created with IntelliJ IDEA.
 * User: chrisreichel
 * Date: 30/11/2013
 * Time: 12:52
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("serial")
public class InvalidRequestException extends RuntimeException {
    private Errors errors;

    public InvalidRequestException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}
