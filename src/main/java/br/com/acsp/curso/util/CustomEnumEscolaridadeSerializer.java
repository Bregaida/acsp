package br.com.acsp.curso.util;

import br.com.acsp.curso.domain.EscolaridadeType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Pedro
 * Date: 27/08/13
 * Time: 16:44
 * To change this template use File | Settings | File Templates.
 */
public class CustomEnumEscolaridadeSerializer extends JsonSerializer<EscolaridadeType> {

    @Override
    public void serialize(EscolaridadeType value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeString(String.valueOf(value.getId()));
    }
}
