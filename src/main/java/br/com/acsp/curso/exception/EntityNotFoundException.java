package br.com.acsp.curso.exception;

/**
 * Created with IntelliJ IDEA.
 * User: christian.reichel
 * Date: 20/08/13
 * Time: 14:26
 */
public class EntityNotFoundException extends RuntimeException {


    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }

    public EntityNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
