package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaAltera {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Contato contato = new Contato();
		contato.setId((long) 1);
		contato.setNome("RJ");
		contato.setEmail("rj@rj.com.br");
		contato.setEndereco("Rua Rj, 1 - RJ");
		
		Calendar data = Calendar.getInstance();		
		contato.setDataNascimento(data);
		
		ContatoDao dao = new ContatoDao();
		dao.altera(contato);
		
		System.out.println("ALTERADO COM SUCESSO!");

	}

}
