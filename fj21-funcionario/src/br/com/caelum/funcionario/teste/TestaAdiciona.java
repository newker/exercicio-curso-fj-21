package br.com.caelum.funcionario.teste;

import br.com.caelum.funcionario.dao.FuncionarioDao;
import br.com.caelum.funcionario.modelo.Funcionario;

public class TestaAdiciona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome("hek");
		funcionario.setUsuario("hek2019");
		funcionario.setSenha("hek@2019");
		
		FuncionarioDao dao = new FuncionarioDao();
		dao.adiciona(funcionario);
		
		System.out.println("Funcionario " + funcionario.getNome() + " adicionado com seucesso!");

	}

}
