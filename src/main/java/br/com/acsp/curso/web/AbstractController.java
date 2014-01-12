package br.com.acsp.curso.web;

import br.com.acsp.curso.domain.Aeronave;
import br.com.acsp.curso.domain.EscolaridadeType;
import br.com.acsp.curso.exception.InvalidRequestException;
import br.com.acsp.curso.util.CustomEnumEscolaridadeEditor;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author pedrosa
 */
public abstract class AbstractController {

    public static final String FRM_DATE_FMT = "dd/MM/yyyy";

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(FRM_DATE_FMT);
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        binder.registerCustomEditor(List.class, "aeronaves", new CustomCollectionEditor(List.class) {
            @Override
            protected Object convertElement(Object element) {
                Aeronave aeronave = new Aeronave();
                if (element != null) {
                    aeronave.setId(element.toString());
                }
                return aeronave;
            }
        });
        binder.registerCustomEditor(EscolaridadeType.class, new CustomEnumEscolaridadeEditor());
    }

    public void validateBindingResult(BindingResult result) {
        if (result.hasErrors()) {
            throw new InvalidRequestException("Bean not valid", result);
        }

    }

}
