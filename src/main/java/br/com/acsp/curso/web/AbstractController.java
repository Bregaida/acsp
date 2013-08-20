package br.com.acsp.curso.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import br.com.acsp.curso.domain.Aeronave;
import br.com.acsp.curso.service.AeronaveService;


/**
 * @author pedrosa
 */
public abstract class AbstractController {

    public static final String FRM_DATE_FMT = "dd/MM/yyyy";
    
    @Autowired private AeronaveService aeronaveService;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(FRM_DATE_FMT);
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        binder.registerCustomEditor(Set.class, "aeronaves", new CustomCollectionEditor(Set.class) {
            protected Object convertElement(Object element) {
                if (element instanceof Aeronave) {
                    return element;
                }
                if (element instanceof String) {
                    return aeronaveService.obtemPorId(Long.valueOf(element.toString()));
                }
                
                return null;
            }
        });
        

    }

}
