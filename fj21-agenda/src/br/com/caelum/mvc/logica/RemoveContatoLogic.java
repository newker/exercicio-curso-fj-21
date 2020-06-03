package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class RemoveContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		long id = Long.parseLong(req.getParameter("id"));
		
		Contato contato = new Contato();
		contato.setId(id);
		
		//buscando a conex�o pendurada (enviada) na requisi��o.
		Connection connection = (Connection) req.getAttribute("connection");
		ContatoDao dao = new ContatoDao(connection);
		dao.remove(contato);
		
		System.out.println("CONTATO EXCLUIDO COM SUCESSO!");
		
		return "mvc?logica=ListaContatosLogic";
	}

}
