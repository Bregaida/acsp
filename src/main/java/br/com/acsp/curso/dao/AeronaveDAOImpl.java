/**
 * 
 */
package br.com.acsp.curso.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import br.com.acsp.curso.domain.clazz.Aeronave;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

/**
 * @author eduardobregaida
 * 
 */

@Component
@RequestScoped
public class AeronaveDAOImpl implements AeronaveDAO {

	private static List<Aeronave> aeronaves;

	public AeronaveDAOImpl() {
		if (aeronaves == null) {
			aeronaves = new ArrayList<Aeronave>();
		}
	}

	public Boolean salvar(Aeronave aeronave) {
		return aeronaves.add(aeronave);
	}

	public Boolean alterar(Aeronave aeronave) {
		return aeronaves.add(aeronave);
	}

	public Boolean excluir(Aeronave aeronave) {
		Iterator<Aeronave> it = aeronaves.iterator();
		while (it.hasNext()) {
			Aeronave aeronaveExistente = it.next();
			if (aeronaveExistente.getId().equals(aeronaveExistente.getId())) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	public List<Aeronave> pesquisarTodos() {
		return Collections.unmodifiableList(aeronaves);
	}

}
