package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.caelum.jdbc.exception.DaoException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/bd?useTimezone=true&serverTimezone=UTC","root","admmaster");
		}catch(SQLException e) {
			throw new DaoException("Conexão com o banco não pode ser realizada. Verifique a conexão.");
		}
	}
}
