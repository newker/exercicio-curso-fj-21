<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="resources/jquery-3.4.1.min.js"></script>
	<meta charset="ISO-8859-1">
	<title>Lista de Tarefas</title>
</head>
<body>

	<script type="text/javascript">
		function finalizaAgora(id){
			$.post("finalizaTarefa",{'id':id}, function(){
				//selecionando o elemento HTML através da id e alterando o HTML dele.
				$("#tarefa_"+id).html("Finalizado");
			});
		}
	</script>
	
	<a href="novaTarefa">Criar nova tarefa</a>
	
	<br/><br/>
	
	<table>
		<tr>
			<th>Id</th>
			<th>Descrição</th>
			<th>Finalizado?</th>
			<th>Data de Finalização</th>
			<th>Remoção</th>
			<th>Alteração</th>
		</tr>
		<c:forEach items="${tarefa}" var="tarefa">
			<tr>
				<td>${tarefa.id}</td>
				<td>${tarefa.descricao}</td>
				<c:if test="${tarefa.finalizado eq false }">
					<td id="tarefa_${tarefa.id}">
						<a href="#" onclick="finalizaAgora(${tarefa.id})">
							Finaliza agora!
						</a>
					</td>
				</c:if>
				<c:if test="${tarefa.finalizado eq true }">
					<td>Finalizado</td>
				</c:if>
				<td>
					<fmt:formatDate value="${tarefa.dataFinalizacao.time }" pattern="dd/MM/yyyy"/>
				</td>
				<td>
					<a href="removeTarefa?id=${tarefa.id}">Remover</a>
				</td>
				<td>
					<a href="mostraTarefa?id=${tarefa.id}">Alterar</a>
				</td>								
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>