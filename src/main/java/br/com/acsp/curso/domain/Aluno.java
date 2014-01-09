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
@DiscriminatorValue("ALUNO_PILOTO")
public class Aluno extends Piloto {

}
