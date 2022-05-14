package br.com.cotiinformatica.interfaces;

import java.util.List;

import br.com.cotiinformatica.entities.Tarefa;

public interface ITarefaRepository {

	void create(Tarefa tarefa) throws Exception;

	void update(Tarefa tarefa) throws Exception;

	void delete(Tarefa tarefa) throws Exception;

	List<Tarefa> findAll(String nome, Integer idUsuario) throws Exception;

	Tarefa findById(Integer idTarefa) throws Exception;

}
