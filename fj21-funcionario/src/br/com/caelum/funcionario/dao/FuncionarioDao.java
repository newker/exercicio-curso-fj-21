package br.com.caelum.funcionario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.funcionario.jdbc.ConnectionFactory;
import br.com.caelum.funcionario.modelo.Funcionario;

public class FuncionarioDao {
	
	private Connection connection;
	
	public FuncionarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	//método para adicionar funcionario
	public void adiciona(Funcionario funcionario) {
		try {
			
			String sql = "INSERT INTO funcionarios (nome,usuario,senha) VALUES (?,?,?)";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//método para retornar todos os funcionarios
	public List<Funcionario> getLista() {
		
		List<Funcionario> lista = new ArrayList<Funcionario>();
				
		try {
			
			String sql = "SELECT * FROM funcionarios";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setNome(rs.getString("nome"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));
				lista.add(funcionario);
			}
			
			rs.close();
			stmt.close();
			
			return lista;
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//método para pesquisar um funcionario pelo id
	public Funcionario getPesquisa(int id) {
		try {
			String sql = "SELECT * FROM funcionarios WHERE id=" + id;
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			Funcionario funcionario = new Funcionario();
			
			while(rs.next()) {
				if(rs.getLong(id) == id) {
					funcionario.setId(rs.getLong("id"));
					funcionario.setNome(rs.getString("nome"));
					funcionario.setUsuario(rs.getString("usuario"));
					funcionario.setSenha(rs.getString("senha"));
				}
			}
			
			return funcionario;
			
		}catch(SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public void getAltera(Funcionario funcionario) {
		try {
			
			String sql = "UPDATE funcionarios SET nome=?,usuario=?,senha=? WHERE id=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.setLong(4, funcionario.getId());
			
			stmt.execute();
			
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void getRemove(Funcionario funcionario) {
		
		try {
			
			String sql = "DELETE FROM funcionarios WHERE id=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setLong(1, funcionario.getId());
			
			stmt.execute();
			
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
