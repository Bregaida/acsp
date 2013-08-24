/**
 *
 */
package br.com.acsp.curso.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acsp.curso.domain.Atendente;
import br.com.acsp.curso.repository.AtendenteRepository;

/**
 * @author eduardobregaida
 */

@Service
@Transactional
public class AtendenteService extends AbstractService<Atendente, Long> {

	@Autowired
	public void setRepository(AtendenteRepository repository) {
		super.repository = repository;
	}

	public Collection<Atendente> listarOrdenado() {
		return ((AtendenteRepository) repository).listarOrdenadoPorNome();
	}
}
