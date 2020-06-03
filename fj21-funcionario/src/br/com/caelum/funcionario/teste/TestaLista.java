package br.com.caelum.funcionario.teste;

import java.util.List;

import br.com.caelum.funcionario.dao.FuncionarioDao;
import br.com.caelum.funcionario.modelo.Funcionario;

public class TestaLista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FuncionarioDao dao = new FuncionarioDao();
		List<Funcionario> lista = dao.getLista();
		
		for(Funcionario funcionario:lista) {
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Usuario: " + funcionario.getUsuario());
			System.out.println("Senha: " + funcionario.getSenha());
			System.out.println("-----------------------------------------");
		}
		
		

	}

}
