package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) {
		
		//montando o contato
		Contato contato = new Contato();
		contato.setNome("Ricardo Ribeiro Junior");
		contato.setEmail("ricardoribeiro.j7@gmail.com");
		contato.setEndereco("Travessa Vila Nova, 348-A Curi�");
		contato.setDataNascimento(Calendar.getInstance());
		
		//gravar nesta conex�o
		ContatoDao dao = new ContatoDao();
		
		//m�todo elegante
		dao.adiciona(contato);
		
		System.out.println("GRAVADO COM SUCESSO!");

	}

}
