package br.com.acsp.curso.repository;

import br.com.acsp.curso.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User: Christian Reichel
 * Date: 8/30/13
 * Time: 9:27 PM
 */
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    public Pessoa findByCpf(Long cpf);
}
