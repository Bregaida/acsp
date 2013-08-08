/**
 * 
 */
package br.com.acsp.curso.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import br.com.acsp.curso.domain.clazz.Instrutor;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

/**
 * @author eduardobregaida
 * 
 */

@Component
@RequestScoped
public class InstrutorDAOImpl implements InstrutorDAO {

	private static List<Instrutor> instrutores;

	public InstrutorDAOImpl() {
		if (instrutores == null) {
			instrutores = new ArrayList<Instrutor>();
		}
	}

	public Boolean salvar(Instrutor instrutor) {
		return instrutores.add(instrutor);

	}

	public Boolean alterar(Instrutor instrutor) {
		return instrutores.add(instrutor);
	}

	public Boolean excluir(Instrutor instrutor) {
		Iterator<Instrutor> it = instrutores.iterator();
		while (it.hasNext()) {
			Instrutor instrutorExistente = it.next();
			if (instrutorExistente.getId().equals(instrutorExistente.getId())) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	public List<Instrutor> pesquisarTodos() {
		return Collections.unmodifiableList(instrutores);
	}

}
