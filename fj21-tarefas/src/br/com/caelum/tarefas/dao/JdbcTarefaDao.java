package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.tarefas.modelo.Tarefa;

public class JdbcTarefaDao {
	
	private Connection connection;
	
	public JdbcTarefaDao(Connection connection) {
		this.connection = connection;
	}
	
	public void adiciona(Tarefa tarefa) {
		
		String sql = "insert into tarefas" + "(descricao)" + "values(?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, tarefa.getDescricao());
			
			stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Tarefa> lista() {
		try {
			List<Tarefa> tarefas = new ArrayList<Tarefa>();
			
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM tarefas");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));
				
				
				
				tarefas.add(tarefa);
				
			}
			
				
			rs.close();
			stmt.close();
			
			return tarefas;
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void remove(Tarefa tarefa) {
		try {
			
			String sql = "DELETE FROM tarefas WHERE id = ?";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setLong(1, tarefa.getId());
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e) {
			new RuntimeException(e);
		}
	}
	
	public Tarefa buscaPorId(Long id) {
		try {
			
			Tarefa tarefa = new Tarefa();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM tarefas WHERE id=" + id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				if(rs.getLong("id") == id) {
					tarefa.setId(rs.getLong("id"));
					tarefa.setDescricao(rs.getString("descricao"));
					tarefa.setFinalizado(rs.getBoolean("finalizado"));
					
					
					
				}
			}
			
			rs.close();
			stmt.close();
			
			return tarefa;
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Tarefa tarefa) {
		
		try {
			String sql = "update tarefas set descricao=?, finalizado=?, dataFinalizacao=? where id=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			stmt.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			stmt.setLong(4, tarefa.getId());
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public void finaliza(Long id) {
		
		try {
			String sql = "update tarefas set finalizado=? where id=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setBoolean(1, true);
			stmt.setLong(2, id);
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
