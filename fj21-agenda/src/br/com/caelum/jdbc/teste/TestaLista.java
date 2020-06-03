package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaLista {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		ContatoDao dao = new ContatoDao();
		
		//Pegando a lista  com o getLista do dao
		List<Contato> contatos = dao.getLista();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//Percorrendo a lista para imprimir os registros
		for(Contato contato:contatos) {
			System.out.println("Nome:" + contato.getNome());
			System.out.println("Email:" + contato.getEmail());
			System.out.println("Endereco:" + contato.getEndereco());
			System.out.println("Data de Nascimento:" + sdf.format(contato.getDataNascimento().getTime()));
			System.out.println("-------------------------------------------------------------------");
		}

	}

}
