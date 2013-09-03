/**
 * 
 */
package br.com.acsp.curso.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.acsp.curso.domain.Horario;
import br.com.acsp.curso.repository.HorarioRepository;

/**
 * @author eduardobregaida
 * 
 */
@Service
public class HorarioService extends AbstractService<Horario, Long> {

	@Autowired
	public void setRepository(HorarioRepository repository) {
		super.repository = repository;
	}

	public Collection<Horario> listarOrdenado() {
		return ((HorarioRepository) repository).listarOrdenadoPorId();
	}

}
