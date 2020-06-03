package br.com.caelum.tarefas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.caelum.tarefas.exception.DaoException;


public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/bd?useTimezone=true&serverTimezone=UTC","root","admmaster");
		}catch(SQLException e) {
			throw new DaoException("Conex�o com o banco n�o pode ser realizada. Verifique a conex�o.");
		}catch(ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}
