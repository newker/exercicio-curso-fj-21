package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaPesquisa {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		ContatoDao dao = new ContatoDao();
		
		Contato contato = dao.pesquisar(3);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("ID: " + contato.getId());
		System.out.println("NOME: " + contato.getNome());
		System.out.println("EMAIL: " + contato.getEmail());
		System.out.println("ENDERECO: " + contato.getEndereco());
		System.out.println("DATA DE NASCIMENTO: " + sdf.format(contato.getDataNascimento().getTime()));
		

	}

}
