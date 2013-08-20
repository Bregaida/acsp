package br.com.acsp.curso.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import br.com.acsp.curso.domain.Aeronave;

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
        binder.registerCustomEditor(List.class, "aeronaves",new CustomCollectionEditor(List.class){
            @Override
            protected Object convertElement(Object element) {
                Aeronave aeronave = new Aeronave();
                if (element != null) {
                    Long id = Long.valueOf(element.toString());
                    aeronave.setId(id);
                }
                return aeronave;
            }
        });

    }

}
