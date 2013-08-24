package br.com.acsp.curso.util;

import br.com.acsp.curso.domain.EscolaridadeType;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 * User: Pedro
 * Date: 22/08/13
 * Time: 20:59
 * To change this template use File | Settings | File Templates.
 */
public class CustomEnumEscolaridadeEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        int c = 0;
        try {
            c = Integer.parseInt(text);
            this.setValue(EscolaridadeType.getInstance(c));
        } catch (NumberFormatException e) {
            //TODO melhorar ou loggar erro?
            this.setValue(EscolaridadeType.FUNDAMENTAL);
        }
    }
}