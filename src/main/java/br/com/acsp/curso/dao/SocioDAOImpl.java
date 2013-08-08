/**
 * 
 */
package br.com.acsp.curso.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import br.com.acsp.curso.domain.clazz.Socio;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

/**
 * @author eduardobregaida
 * 
 */

@Component
@RequestScoped
public class SocioDAOImpl implements SocioDAO {

	private static List<Socio> socios;

	public SocioDAOImpl() {
		if (socios == null) {
			socios = new ArrayList<Socio>();
		}
	}

	public Boolean salvar(Socio socio) {
		return socios.add(socio);

	}

	public Boolean alterar(Socio socio) {
		return socios.add(socio);
	}

	public Boolean excluir(Socio aluno) {
		Iterator<Socio> it = socios.iterator();
		while (it.hasNext()) {
			Socio socioExistente = it.next();
			if (socioExistente.getId().equals(socioExistente.getId())) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	public List<Socio> pesquisarTodos() {
		return Collections.unmodifiableList(socios);
	}

}
