/**
 *
 */
package br.com.acsp.curso.domain;

import javax.persistence.*;

/**
 * @author pedrosa
 */

@Entity
public class Pista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nomePista;

    
}
