package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.caelum.tarefas.modelo.Usuario;

public class JdbcUsuarioDao {
	
	private Connection connection;
	boolean retorno = false;
	
	public JdbcUsuarioDao(Connection connection) {
		this.connection = connection;
	}
	
	public boolean existeUsuario(Usuario usuario) {
		
		try {
			
			
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM usuarios");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				if(rs.getString("login").equals(usuario.getLogin())) {
					retorno = true;
				}
			}
			
			rs.close();
			stmt.close();
		
			
		}catch(SQLException e) {
			new RuntimeException(e);
		}
		
		return retorno;

		
	}

}
