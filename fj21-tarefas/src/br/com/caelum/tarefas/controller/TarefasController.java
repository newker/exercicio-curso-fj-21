package br.com.caelum.tarefas.controller;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefasController {
	
	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}
	
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result,HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//buscando a conexão pendurada (enviada) na requisição.
		Connection connection = (Connection) request.getAttribute("connection");
		
		if(result.hasFieldErrors("descricao")) {
			return "/tarefa/formulario";
		}
		
		JdbcTarefaDao dao = new JdbcTarefaDao(connection);
		dao.adiciona(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("listaTarefas")
	public String lista(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		Connection connection = (Connection) request.getAttribute("connection");
		
		JdbcTarefaDao dao = new JdbcTarefaDao(connection);
		List<Tarefa> tarefas = dao.lista();
		model.addAttribute("tarefa",tarefas);
		return "/tarefa/lista";
	}
	
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa, HttpServletRequest request, HttpServletResponse response) {
		
		Connection connection = (Connection) request.getAttribute("connection");
		
		JdbcTarefaDao dao = new JdbcTarefaDao(connection);
		dao.remove(tarefa);
		return "redirect:listaTarefas";
		
	}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Model model, Long id, HttpServletResponse response, HttpServletRequest request) {
		
		Connection connection = (Connection) request.getAttribute("connection");		
		JdbcTarefaDao dao = new JdbcTarefaDao(connection);		
		model.addAttribute("tarefa", dao.buscaPorId(id));		
		return "/tarefa/mostra";
		
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa, HttpServletRequest request, HttpServletResponse response) {
		
		Connection connection = (Connection) request.getAttribute("connection");
		
		JdbcTarefaDao dao = new JdbcTarefaDao(connection);
		dao.altera(tarefa);
		
		
		return "redirect:listaTarefas";
	}
	
	@ResponseBody
	@RequestMapping("finalizaTarefa")
	public void finaliza(Long id, HttpServletRequest request) {
		
		Connection connection = (Connection) request.getAttribute("connection");
		
		JdbcTarefaDao dao = new JdbcTarefaDao(connection);
		dao.finaliza(id);
		
	}

}
