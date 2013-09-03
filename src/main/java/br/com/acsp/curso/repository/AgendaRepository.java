package br.com.acsp.curso.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acsp.curso.domain.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

	public Collection<Agenda> findByDataReservaBetween(Date inicio, Date fim);

	// @Query("select ag.horario.horarioAgenda from Agenda ag")
	// Collection<Horario> listarHorasDisponiveis(Long aeronaveId);
}
