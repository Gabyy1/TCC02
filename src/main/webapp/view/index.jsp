<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href='<c:url value="./resources/css/style.css" />'>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div class="loginform">

		<h1>Olá, seja bem vindo!</h1>
		<h3>Efetue o login para continuar</h3>

		<form action="index" method="post">
			<div class="loginemail">
				<label for="email" class="lbl">Email</label> <input
					class="inputlogin" type="text" id="email" name="email"
					placeholder="Digite seu email">
			</div>
			<div class="loginsenha">
				<label for="senha" class="lbl">Senha</label> <input
					class="inputlogin" type="password" id="senha" name="senha"
					placeholder="Digite sua senha">
			</div>
			<input type="submit" id="btn" name="btn" value="Logar">
		</form>
	</div>
</body>
</html>