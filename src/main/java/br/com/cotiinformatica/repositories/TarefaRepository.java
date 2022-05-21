package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.factories.ConnectionFactory;
import br.com.cotiinformatica.helpers.DateHelper;
import br.com.cotiinformatica.interfaces.ITarefaRepository;

public class TarefaRepository implements ITarefaRepository {

	@Override
	public void create(Tarefa tarefa) throws Exception {

		// Abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();

		// Executar o comando para gravar a tarefa no banco (INSERT)
		PreparedStatement statement = connection.prepareStatement(
				"insert into tarefa(nome, descricao, data, hora, prioridade, idusuario) values(?, ?, ?, ?, ?, ?)");

		statement.setString(1, tarefa.getNome());
		statement.setString(2, tarefa.getDescricao());
		statement.setString(3, DateHelper.formatToString(tarefa.getData()));
		statement.setString(4, tarefa.getHora());
		statement.setInt(5, tarefa.getPrioridade());
		statement.setInt(6, tarefa.getIdUsuario());

		statement.execute();
		statement.close();

		connection.close();
	}

	@Override
	public void update(Tarefa tarefa) throws Exception {

		// Abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();

		// Executar o comando de UPDATE no banco de dados
		PreparedStatement statement = connection.prepareStatement(
				"update tarefa set nome=?, data=?, hora=?, prioridade=?, descricao=? where idtarefa=? and idusuario=?");
		statement.setString(1, tarefa.getNome());
		statement.setString(2, DateHelper.formatToString(tarefa.getData()));
		statement.setString(3, tarefa.getHora());
		statement.setInt(4, tarefa.getPrioridade());
		statement.setString(5, tarefa.getDescricao());
		statement.setInt(6, tarefa.getIdTarefa());
		statement.setInt(7, tarefa.getIdUsuario());

		statement.execute();
		statement.close();

		connection.close();
	}

	@Override
	public void delete(Tarefa tarefa) throws Exception {

		// Abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();

		// Executar o comando de UPDATE no banco de dados
		PreparedStatement statement = connection
				.prepareStatement("delete from tarefa where idtarefa=? and idusuario=?");
		statement.setInt(1, tarefa.getIdTarefa());
		statement.setInt(2, tarefa.getIdUsuario());

		statement.execute();
		statement.close();

		connection.close();
	}

	@Override
	public List<Tarefa> findAll(String nome, Integer idUsuario) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("select * from tarefa where nome like ? and idusuario = ?");
		statement.setString(1, "%" + nome + "%");
		statement.setInt(2, idUsuario);
		ResultSet resultSet = statement.executeQuery();

		List<Tarefa> tarefas = new ArrayList<Tarefa>();

		while (resultSet.next()) {

			Tarefa tarefa = new Tarefa();

			tarefa.setIdTarefa(resultSet.getInt("idtarefa"));
			tarefa.setNome(resultSet.getString("nome"));
			tarefa.setData(DateHelper.formatToDate(resultSet.getString("data")));
			tarefa.setHora(resultSet.getString("hora"));
			tarefa.setPrioridade(resultSet.getInt("prioridade"));
			tarefa.setDescricao(resultSet.getString("descricao"));
			tarefa.setIdUsuario(resultSet.getInt("idusuario"));

			tarefas.add(tarefa); // adicionando na lista
		}

		connection.close();
		return tarefas; // retornando a lista
	}

	@Override
	public Tarefa findById(Integer idTarefa) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from tarefa where idtarefa = ?");
		statement.setInt(1, idTarefa);
		ResultSet resultSet = statement.executeQuery();

		Tarefa tarefa = null;

		if (resultSet.next()) {

			tarefa = new Tarefa();

			tarefa.setIdTarefa(resultSet.getInt("idtarefa"));
			tarefa.setNome(resultSet.getString("nome"));
			tarefa.setData(DateHelper.formatToDate(resultSet.getString("data")));
			tarefa.setHora(resultSet.getString("hora"));
			tarefa.setPrioridade(resultSet.getInt("prioridade"));
			tarefa.setDescricao(resultSet.getString("descricao"));
			tarefa.setIdUsuario(resultSet.getInt("idusuario"));
		}

		connection.close();
		return tarefa;
	}

}
