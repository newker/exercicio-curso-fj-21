<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exibe Contato</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	
	
	
	<h1>ALTERAR CONTATO </h1>
	<hr/>
	<form action="mvc?logica=AlteraContatoLogic" method="post">
		Codigo:<input type="text" name="id" value="${contato.id}"/><br/><br/>
		Nome:<input type="text" name="nome" value="${contato.nome}"/><br/><br/>
		E-mail:<input type="text" name="email" value="${contato.email}"/><br/><br/>
		Endereço:<input type="text" name="endereco" value="${contato.endereco}"/><br/><br/>
		Data de Nascimento:<input type="text" name="dataNascimento" value="<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>"/><br/><br/>
		
		<input type="submit" value="Gravar"/>
	</form>
	
	<c:import url="rodape.jsp"/>
	
</body>
</html>