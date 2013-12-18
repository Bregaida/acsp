package br.com.acsp.curso.web;

import br.com.acsp.curso.exception.ErrorResource;
import br.com.acsp.curso.exception.FieldErrorResource;
import br.com.acsp.curso.exception.InvalidRequestException;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Christian Reichel
 * Date: 8/24/13
 * Time: 3:44 PM
 * http://doanduyhai.wordpress.com/2012/05/06/spring-mvc-part-v-exception-handling/
 */
@ControllerAdvice
public class ErrorControllerHandler extends ResponseEntityExceptionHandler {

    private static final Log LOGGER = LogFactory.getLog(ErrorControllerHandler.class);

    @ExceptionHandler(IOException.class)
    public ModelAndView handleIOException(IOException ex, HttpServletRequest request) {
        LOGGER.info("handleIOException - Catching: " + ex.getClass().getSimpleName());
        return errorModelAndView(ex, request);
    }

    @ExceptionHandler(NullPointerException.class)
    public ModelAndView handleNullPointerException(NullPointerException ex, HttpServletRequest request) {
        LOGGER.info("handleNullpointerException - Catching: " + ex.getClass().getSimpleName());
        return errorModelAndView(ex, request);
    }

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handleRuntimeException(RuntimeException ex, HttpServletRequest request) {
        LOGGER.info("handleRuntimeException - Catching: " + ex.getClass().getSimpleName());
        return errorModelAndView(ex, request);
    }

    @ExceptionHandler({ InvalidRequestException.class })
    protected ResponseEntity<Object> handleInvalidRequest(RuntimeException e, WebRequest request) {
        final InvalidRequestException ire = (InvalidRequestException) e;
        final List<FieldErrorResource> fieldErrorResources = new ArrayList<>();

        final List<FieldError> fieldErrors = ire.getErrors().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            final FieldErrorResource fieldErrorResource = new FieldErrorResource();
            fieldErrorResource.setResource(fieldError.getObjectName());
            fieldErrorResource.setField(fieldError.getField());
            fieldErrorResource.setCode(fieldError.getCode());
            fieldErrorResource.setMessage(fieldError.getDefaultMessage());
            fieldErrorResources.add(fieldErrorResource);
        }

        final ErrorResource error = new ErrorResource("InvalidRequest", ire.getMessage());
        error.setFieldErrors(fieldErrorResources);

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(e, error, headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
    }

    private ModelAndView errorModelAndView(Exception ex, HttpServletRequest request) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("name", ex.getClass().getSimpleName());
        modelAndView.addObject("exception", ex.getMessage());
        modelAndView.addObject("status", request.getAttribute("javax.servlet.error.status_code"));
        modelAndView.addObject("reason", request.getAttribute("javax.servlet.error.message"));
        return modelAndView;
    }
}
