/**
 *
 */
package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Atendente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author eduardobregaida
 */
public interface AtendenteRepository extends JpaRepository<Atendente, Long> {
}
