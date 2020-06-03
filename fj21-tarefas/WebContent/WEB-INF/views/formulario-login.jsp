<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Página de Login das Tarefas</h2>
	<form action="efetuaLogin" method="post">
		Login:<input type="text" name="login"/><br/><br/>
		Senha:<input type="password" name="senha"/><br/><br/>
		<input type="submit" value="Entrar nas Tarefas"/>
	</form>
</body>
</html>