package br.com.acsp.curso.domain.agenda;

import br.com.acsp.curso.domain.aeronave.Aeronave;
import br.com.acsp.curso.domain.horario.Horario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

public interface AgendaRepository extends MongoRepository<Agenda, BigInteger>, QueryDslPredicateExecutor<Agenda> {

    public Collection<Agenda> findByDataReservaBetween(Date inicio, Date fim);

    public Collection<Agenda> findByDataReservaAndAeronave(Date dataReserva, Aeronave aeronave);

    public Collection<Agenda> findByDataReservaAndHorario(Date dataReserva, Horario horario);
}
