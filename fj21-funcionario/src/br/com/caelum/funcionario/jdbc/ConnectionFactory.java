package br.com.caelum.funcionario.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/bd?useTimezone=true&serverTimezone=UTC","root","admmaster");
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
