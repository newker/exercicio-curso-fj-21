package br.com.caelum.mvc.logica;

import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class AdicionaContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//busca o Writer
				PrintWriter out = res.getWriter();
				
				//buscando os par�metros no request
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
					out.println("Erro de convers�o da data");
				}
				
				//monta o objeto contato
				Contato contato = new Contato();
				contato.setNome(nome);
				contato.setEndereco(endereco);
				contato.setEmail(email);
				contato.setDataNascimento(dataNascimento);
				
				//buscando a conex�o pendurada (enviada) na requisi��o.
				Connection connection = (Connection) req.getAttribute("connection");
				
				//salva o contato no banco
				ContatoDao dao = new ContatoDao(connection);
				dao.adiciona(contato);
		
		return "mvc?logica=ListaContatosLogic";
	}

}
