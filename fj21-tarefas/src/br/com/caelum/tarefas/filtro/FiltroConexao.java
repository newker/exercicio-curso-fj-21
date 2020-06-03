package br.com.caelum.tarefas.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caelum.tarefas.jdbc.ConnectionFactory;



@WebFilter("/*")
public class FiltroConexao implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		try {
			Connection connection = new ConnectionFactory().getConnection();
			
			//pendurando a connection na requisição
			request.setAttribute("connection", connection);
			
			chain.doFilter(request, response);
			
			connection.close();
			
		}catch(SQLException e) {
			throw new ServletException(e);
		}
		

	}

}
