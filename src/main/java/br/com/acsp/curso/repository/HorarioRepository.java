/**
 * 
 */
package br.com.acsp.curso.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.acsp.curso.domain.Horario;

/**
 * @author eduardobregaida
 * 
 */
public interface HorarioRepository extends JpaRepository<Horario, Long> {

    @Query("select a from Horario a order by a.id")
    Collection<Horario> listarOrdenadoPorId();

    @Query("select ho.horarioAgenda " + "from  Horario_Aeronave ha "
	    + "left join Aeronave ae on (ae.id = ha.aeronaves_id) "
	    + "left join Agenda as ag  on (ag.aeronave_id = ha.aeronaves_id) "
	    + "left join HORARIO ho on  (ho.id not in "
	    + "		(select distinct ag.horario_id from Agenda ag "
	    + "		where   ag.aeronave_id = :aeronaveId "
	    + "		and ag.dataReserva = :dataReserva)) ")
    Collection<Horario> listarHorariosDisponieisPorAeronave(
	    @Param("aeronaveId") Long aeronaveId,
	    @Param("dataReserva") Date dataReserva);
}