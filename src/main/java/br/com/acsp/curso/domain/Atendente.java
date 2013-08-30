/**
 *
 */
package br.com.acsp.curso.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @author eduardobregaida
 */
@Entity
@DiscriminatorValue("ATENDENTE")
public class Atendente extends Pessoa implements Serializable {

    private static final long serialVersionUID = 6091875744638425844L;
}
