package br.com.acsp.curso.util;

import br.com.acsp.curso.domain.EscolaridadeType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA. User: Pedro Date: 22/08/13 Time: 20:59 To change
 * this template use File | Settings | File Templates.
 */
public class CustomEnumEscolaridadeEditor extends PropertyEditorSupport {

    private static final Log LOGGER = LogFactory.getLog(CustomEnumEscolaridadeEditor.class);

	@Override
	public String getAsText() {
        EscolaridadeType escolaridade = (EscolaridadeType) getValue();
        return (escolaridade != null ? String.valueOf(escolaridade.getId()) : "");
    }

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		int c = 0;
		try {
			c = Integer.parseInt(text);
			this.setValue(EscolaridadeType.getInstance(c));
		} catch (NumberFormatException e) {
			this.setValue(EscolaridadeType.FUNDAMENTAL);
		}
	}
}
