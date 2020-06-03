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
				
				//buscando os parâmetros no request
				String nome = req.getParameter("nome");
				String endereco = req.getParameter("endereco");
				String email = req.getParameter("email");
				String dataEmTexto = req.getParameter("dataNascimento");
				
				//fazendo a conversão da data
				
				Calendar dataNascimento = null;
				
				try {
					Date data = new SimpleDateFormat("dd/MM/YYYY").parse(dataEmTexto);
					dataNascimento = Calendar.getInstance();
					dataNascimento.setTime(data);
				}catch(ParseException e) {
					out.println("Erro de conversão da data");
				}
				
				//monta o objeto contato
				Contato contato = new Contato();
				contato.setNome(nome);
				contato.setEndereco(endereco);
				contato.setEmail(email);
				contato.setDataNascimento(dataNascimento);
				
				//buscando a conexão pendurada (enviada) na requisição.
				Connection connection = (Connection) req.getAttribute("connection");
				
				//salva o contato no banco
				ContatoDao dao = new ContatoDao(connection);
				dao.adiciona(contato);
		
		return "mvc?logica=ListaContatosLogic";
	}

}
