package br.com.acsp.curso.service;

import java.util.List;

import br.com.acsp.curso.domain.clazz.Atendente;

public interface AtendenteService {

	public Boolean salvar(Atendente atendente);

	public Boolean atualizar(Atendente atendente);

	public Boolean excluir(Atendente atendente);

	public List<Atendente> pesquisarTodos();

}
