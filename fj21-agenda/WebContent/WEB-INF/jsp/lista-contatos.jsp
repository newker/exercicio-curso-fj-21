<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Contatos com JSTL/core</title>
</head>
<body>

	<c:import url="cabecalho.jsp"/>
	
	
	
	<table border="1">
		
		<tr>
			<td>NOME</td>
			<td>E-MAIL</td>
			<td>ENDERECO</td>
			<td>DATA DE NASCIMENTO</td>
			<td><a href="mvc?logica=ChamarFormAdicionaContato"><button>ADICIONAR CONTATO</button></a></td>
		</tr>
		
		
		<!-- Percorre os contatos montando a tabela -->
		<c:forEach var="contato" items="${contatos}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
				<td>${contato.nome}</td>
				<td>
					<c:if test="${not empty contato.email}">
						<a href="mailto:${contato.email}">${contato.email}</a>
					</c:if>
				</td>
				<td>${contato.endereco}</td>
				<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
				<td>
					<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
				</td>
				<td>
					<a href="mvc?logica=MostraContatoLogic&id=${contato.id}">Alterar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<c:import url="rodape.jsp"/>
	
</body>
</html>