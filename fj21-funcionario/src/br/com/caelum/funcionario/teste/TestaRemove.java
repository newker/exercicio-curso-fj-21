package br.com.caelum.funcionario.teste;

import br.com.caelum.funcionario.dao.FuncionarioDao;
import br.com.caelum.funcionario.modelo.Funcionario;

public class TestaRemove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Funcionario funcionario = new Funcionario();
		funcionario.setId(3l);
		
		FuncionarioDao dao = new FuncionarioDao();
		dao.getRemove(funcionario);
		
		System.out.println("FUNCIONARIO REMOVIDO COM SUCESSO!");
	}

}
