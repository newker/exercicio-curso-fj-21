package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica {

	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		System.out.println("Executando a l�gica");
		
		System.out.println("Retornando o nome da pagina jsp....");
		
		return "/WEB-INF/jsp/primeira-logica.jsp";
	}

}
