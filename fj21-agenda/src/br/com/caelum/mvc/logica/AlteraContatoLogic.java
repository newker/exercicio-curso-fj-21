package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class AlteraContatoLogic implements Logica {

	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		//buscando os par�metros no request
		long id = Long.parseLong(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String email = req.getParameter("email");
		String dataEmTexto = req.getParameter("dataNascimento");
		
		//fazendo a convers�o da data
		
		Calendar dataNascimento = null;
		
		try {
			Date data = new SimpleDateFormat("dd/MM/YYYY").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
		}catch(ParseException e) {
			System.out.println("Erro de convers�o da data");
		}
		
		//monta o objeto contato
		Contato contato = new Contato();
		contato.setId(id);
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		
		//buscando a conex�o pendurada (enviada) na requisi��o.
		Connection connection = (Connection) req.getAttribute("connection");
		
		//salva o contato no banco
		ContatoDao dao = new ContatoDao(connection);
		dao.altera(contato);
		
		System.out.println("Contato alterado com sucesso!");
		
		return "mvc?logica=ListaContatosLogic";
	}

}
