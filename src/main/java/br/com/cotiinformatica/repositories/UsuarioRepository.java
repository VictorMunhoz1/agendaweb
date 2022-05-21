package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.factories.ConnectionFactory;
import br.com.cotiinformatica.interfaces.IUsuarioRepository;

public class UsuarioRepository implements IUsuarioRepository {

	@Override
	public void create(Usuario usuario) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("insert into usuario(nome, email, senha) values(?, ?, md5(?))");
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getEmail());
		statement.setString(3, usuario.getSenha());
		statement.execute();
		statement.close();

		connection.close();
	}

	@Override
	public void update(Usuario usuario) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("update usuario set nome=?, email=?, senha=md5(?) where idusuario=?");
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getEmail());
		statement.setString(3, usuario.getSenha());
		statement.setInt(4, usuario.getIdUsuario());
		statement.execute();
		statement.close();

		connection.close();
	}

	@Override
	public void update(Integer idUsuario, String senha) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("update usuario set senha=md5(?) where idusuario=?");
		statement.setString(1, senha);
		statement.setInt(2, idUsuario);
		statement.execute();
		statement.close();

		connection.close();
	}

	@Override
	public void delete(Usuario usuario) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("delete from usuario where idusuario=?");
		statement.setInt(1, usuario.getIdUsuario());
		statement.execute();
		statement.close();

		connection.close();
	}

	@Override
	public List<Usuario> findAll() throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from usuario");
		ResultSet resultSet = statement.executeQuery();

		List<Usuario> lista = new ArrayList<Usuario>();

		while (resultSet.next()) { // enquanto houver registros

			Usuario usuario = new Usuario();

			usuario.setIdUsuario(resultSet.getInt("idusuario"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setEmail(resultSet.getString("email"));
			usuario.setSenha(resultSet.getString("senha"));

			lista.add(usuario);
		}

		connection.close();
		return lista;
	}

	@Override
	public Usuario findById(Integer idUsuario) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from usuario where idusuario=?");
		statement.setInt(1, idUsuario);
		ResultSet resultSet = statement.executeQuery();

		Usuario usuario = null; // vazio

		if (resultSet.next()) { // se algum registro foi encontrado

			usuario = new Usuario();

			usuario.setIdUsuario(resultSet.getInt("idusuario"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setEmail(resultSet.getString("email"));
			usuario.setSenha(resultSet.getString("senha"));
		}

		connection.close();
		return usuario;
	}

	@Override
	public Usuario find(String email) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from usuario where email=?");
		statement.setString(1, email);
		ResultSet resultSet = statement.executeQuery();

		Usuario usuario = null; // vazio

		if (resultSet.next()) { // se algum registro foi encontrado

			usuario = new Usuario();

			usuario.setIdUsuario(resultSet.getInt("idusuario"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setEmail(resultSet.getString("email"));
			usuario.setSenha(resultSet.getString("senha"));
		}

		connection.close();
		return usuario;
	}

	@Override
	public Usuario find(String email, String senha) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("select * from usuario where email=? and senha=md5(?)");
		statement.setString(1, email);
		statement.setString(2, senha);
		ResultSet resultSet = statement.executeQuery();

		Usuario usuario = null; // vazio

		if (resultSet.next()) { // se algum registro foi encontrado

			usuario = new Usuario();

			usuario.setIdUsuario(resultSet.getInt("idusuario"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setEmail(resultSet.getString("email"));
			usuario.setSenha(resultSet.getString("senha"));
		}

		connection.close();
		return usuario;
	}

}
