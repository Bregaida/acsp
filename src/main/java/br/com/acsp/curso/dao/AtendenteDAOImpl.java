/**
 * 
 */
package br.com.acsp.curso.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import br.com.acsp.curso.domain.clazz.Atendente;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

/**
 * @author eduardobregaida
 * 
 */
@Component
@RequestScoped
public class AtendenteDAOImpl implements AtendenteDAO {

	private static List<Atendente> atendentes;

	public AtendenteDAOImpl() {
		if (atendentes == null) {
			atendentes = new ArrayList<Atendente>();
		}
	}

	public Boolean salvar(Atendente atendente) {
		return atendentes.add(atendente);
	}

	public Boolean alterar(Atendente atendente) {
		return atendentes.add(atendente);
	}

	public Boolean excluir(Atendente atendente) {
		Iterator<Atendente> it = atendentes.iterator();
		while (it.hasNext()) {
			Atendente atendenteExistente = it.next();
			if (atendenteExistente.getId().equals(atendenteExistente.getId())) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	public List<Atendente> pesquisarTodos() {
		return Collections.unmodifiableList(atendentes);
	}

}
