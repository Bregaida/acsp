/**
 *
 */
package br.com.acsp.curso.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author eduardobregaida
 */
@Entity
@DiscriminatorValue("ATENDENTE")
public class Atendente extends Pessoa{

}
