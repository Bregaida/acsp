/**
 *
 */
package br.com.acsp.curso.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.acsp.curso.domain.Aeronave;
import br.com.acsp.curso.repository.AeronaveRepository;

/**
 * @author eduardobregaida
 */

@Service
public class AeronaveService extends AbstractService<Aeronave, Long> {

	@Autowired
	public void setRepository(AeronaveRepository repository) {
		super.repository = repository;
	}

	public Collection<Aeronave> listarOrdenadoPorModelo() {
		return ((AeronaveRepository) repository).listarOrdenadoPorModelo();
	}
}
