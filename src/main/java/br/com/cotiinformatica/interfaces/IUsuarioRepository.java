package br.com.cotiinformatica.interfaces;

import java.util.List;

import br.com.cotiinformatica.entities.Usuario;

public interface IUsuarioRepository {

	void create(Usuario usuario) throws Exception;

	void update(Usuario usuario) throws Exception;

	void delete(Usuario usuario) throws Exception;

	List<Usuario> findAll() throws Exception;

	Usuario findById(Integer idUsuario) throws Exception;

	Usuario find(String email) throws Exception;

	Usuario find(String email, String senha) throws Exception;
}
