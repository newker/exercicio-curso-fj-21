package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class MostraContatoLogic implements Logica {


	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		long id = Long.parseLong(req.getParameter("id"));
		
		//buscando a conexão pendurada (enviada) na requisição.
		Connection connection = (Connection) req.getAttribute("connection");
		
		ContatoDao dao = new ContatoDao(connection);
		
		Contato contato = dao.pesquisar(id);
		
		req.setAttribute("contato", contato);
		
		return "/WEB-INF/jsp/exibe-contato.jsp";
	}

}
