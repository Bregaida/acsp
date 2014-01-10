package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Aeronave;
import br.com.acsp.curso.domain.Agenda;
import br.com.acsp.curso.domain.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Date;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

	public Collection<Agenda> findByDataReservaBetween(Date inicio, Date fim);

    public Collection<Agenda> findByDataReservaAndAeronave(Date dataReserva, Aeronave aeronave);

    public Collection<Agenda> findByDataReservaAndHorario(Date dataReserva, Horario horario);
}
