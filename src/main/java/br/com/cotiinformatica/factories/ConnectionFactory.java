package br.com.cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// static final -> constantes
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agendaweb?useTimezone=true&serverTimezone=UTC&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "coti";

	// método para retornar a conexão
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	}

}
