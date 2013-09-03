package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Date;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    public Collection<Agenda> findByDataReservaBetween(Date inicio, Date fim);

}
