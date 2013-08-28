package br.com.acsp.curso.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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
