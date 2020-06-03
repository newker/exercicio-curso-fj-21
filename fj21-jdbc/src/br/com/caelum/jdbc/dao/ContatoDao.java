package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {
	//a conexão com o banco de dados.
	private Connection connection;
	
	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	//método para adicionar um contato
	public void adiciona(Contato contato) {
		//montando a String (statement/declaração)
		String sql = "insert into contatos" + "(nome,email,endereco,dataNascimento)" + "values(?,?,?,?)";
		
		try {
			//recebendo um PreparedStatement de uma conexão para inserção.
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//seta valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			//executa
			stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getLista(){
		try {
			//criando a lista
			List<Contato> contatos = new ArrayList<Contato>();
			//preparando a instrução SQL e motando a tabela com o ResultSet
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				//criando o objeto contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				//montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				//adicionando o objeto a lista
				contatos.add(contato);
			}
			
			rs.close();
			stmt.close();
			
			return contatos;
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Contato pesquisar(int id) {
				
		try {
			Contato contato = new Contato();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM CONTATOS WHERE ID =" + id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getLong(id) == id) {
					contato.setId(rs.getLong("id"));
					contato.setNome(rs.getString("nome"));
					contato.setEmail(rs.getString("email"));
					contato.setEndereco(rs.getString("endereco"));
					
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("dataNascimento"));
					contato.setDataNascimento(data);
				}
			}
			
			rs.close();
			stmt.close();
			
			return contato;
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Contato contato) {
		try {
			String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2,contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Contato contato) {
		try {
			
			String sql = "DELETE FROM CONTATOS WHERE id = ?";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setLong(1, contato.getId());
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
