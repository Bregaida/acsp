package br.com.acsp.curso.domain;

import java.io.Serializable;

/**
 * User: Christian Reichel
 * Date: 8/30/13
 * Time: 8:24 PM
 */
public enum ClassificacaoPessoaType implements Serializable {

    ALUNO("ALUNO_PILOTO"),
    ATENDENTE("ATENDENTE"),
    INSTRUTOR("INSTRUTOR_PILOTO"),
    PILOTO("PILOTO"),
    SOCIO("SOCIO_PILOTO");

    private final String tipo;

    private ClassificacaoPessoaType(String type){
        tipo = type;
    }

    public String getTipo() {
        return tipo;
    }

    public static ClassificacaoPessoaType getInstance(String val) {
        ClassificacaoPessoaType enumObj = null;
        for (ClassificacaoPessoaType element : ClassificacaoPessoaType.values()) {
            if (element.getTipo().equals(val)) {
                enumObj = element;
                break;
            }
        }
        return enumObj;
    }
}
