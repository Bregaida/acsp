package br.com.acsp.curso.common;

import org.springframework.data.annotation.Id;

/**
 * User: chrisreichel
 * Date: 11/01/2014
 * Time: 21:21
 */
public abstract class AbstractDocument {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
