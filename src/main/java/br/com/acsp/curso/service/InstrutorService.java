/**
 *
 */
package br.com.acsp.curso.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.acsp.curso.domain.Instrutor;
import br.com.acsp.curso.repository.InstrutorRepository;

/**
 * @author eduardobregaida
 */

@Service
public class InstrutorService extends AbstractService<Instrutor, Long> {

	@Autowired
	public void setRepository(InstrutorRepository repository) {
		super.repository = repository;
	}

	public Collection<Instrutor> listarOrdenado() {
		return ((InstrutorRepository) repository).listarOrdenadoPorNome();
	}

	public Collection<Instrutor> listarInstrutoresDisponiveisPorHoraAeronaveAula(
			Long horaId, Long aeronaveId, Long aulaId) {
		return ((InstrutorRepository) repository)
				.listarInstrutoresDisponiveisPorHoraAeronaveAula(horaId,
						aeronaveId, aulaId);
	}

}
