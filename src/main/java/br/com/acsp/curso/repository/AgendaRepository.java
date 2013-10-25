package br.com.acsp.curso.repository;

import java.util.Collection;
import java.util.Date;

import br.com.acsp.curso.domain.Aeronave;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acsp.curso.domain.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

	public Collection<Agenda> findByDataReservaBetween(Date inicio, Date fim);

    public Collection<Agenda> findByDataReservaAndAeronave(Date dataReserva, Aeronave aeronave);

	// @Query("select ag.horario.horarioAgenda from Agenda ag")
	// Collection<Horario> listarHorasDisponiveis(Long aeronaveId);
}
