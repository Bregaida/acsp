/**
 * 
 */
package br.com.acsp.curso.service;

import br.com.acsp.curso.domain.Horario;
import br.com.acsp.curso.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

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
