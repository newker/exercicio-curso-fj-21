package br.com.caelum.funcionario.teste;

import br.com.caelum.funcionario.dao.FuncionarioDao;
import br.com.caelum.funcionario.modelo.Funcionario;

public class TestaPesquisa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FuncionarioDao dao = new FuncionarioDao();
		
		Funcionario funcionario = dao.getPesquisa(2);
		
		System.out.println("ID: " + funcionario.getId());
		System.out.println("NOME: " + funcionario.getNome());
		System.out.println("USUARIO: " + funcionario.getUsuario());
		System.out.println("SENHA: " + funcionario.getSenha());

	}

}
