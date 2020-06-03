package br.com.caelum.funcionario.teste;

import br.com.caelum.funcionario.dao.FuncionarioDao;
import br.com.caelum.funcionario.modelo.Funcionario;

public class TestaAltera {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Funcionario funcionario = new Funcionario();
		funcionario.setId(2l);
		funcionario.setNome("Valeska Carvalho");
		funcionario.setUsuario("valeska");
		funcionario.setSenha("123");
		
		FuncionarioDao dao = new FuncionarioDao();
		dao.getAltera(funcionario);
		
		System.out.println("CONTATO ALTERADO COM SUCESSO!");
		

	}

}
