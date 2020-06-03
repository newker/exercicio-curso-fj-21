<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bem Vindo com JSP</title>
</head>
<body>
	<%-- comentário em JSP aqui: nossa primeira página JSP --%>
	
	<%String messagem = "Bem vindo ao sistema de agenda do FJ-21!";%>
	<%out.println(messagem); %>
	
	<br/>
	
	<% String desenvolvido = "Desenvolvido por Ricardo Junior"; %>
	<%=desenvolvido %>
	
	<br/>
	
	<%System.out.println("Tudo foi executado com sucesso!"); %>
</body>
</html>