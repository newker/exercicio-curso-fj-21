package br.com.caelum.funcionario.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.caelum.funcionario.jdbc.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("CONEXÃO ABERTA!");
		connection.close();
	}

}
