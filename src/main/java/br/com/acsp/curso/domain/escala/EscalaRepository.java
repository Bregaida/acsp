/**
 * 
 */
package br.com.acsp.curso.domain.escala;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.acsp.curso.domain.agenda.Agenda;

/**
 * @author eduardobregaida
 * 
 */
public interface EscalaRepository extends MongoRepository<Escala, String> {

    public Collection<Agenda> findByDataReservaBetween(Date inicioDiaMes,
	    Date fimDiaMes);

}
