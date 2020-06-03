<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>ADICIONA CONTATOS</h1>
	<hr/>
	<form action="mvc?logica=AdicionaContatoLogic" method="post">
		Nome:<input type="text" name="nome"/><br/><br/>
		E-mail:<input type="text" name="email"/><br/><br/>
		Endereço:<input type="text" name="endereco"/><br/><br/>
		Data de Nascimento:<input type="text" name="dataNascimento"/><br/><br/>
		
		<input type="submit" value="Gravar"/>
</body>
</html>