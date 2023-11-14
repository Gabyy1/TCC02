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
  <div class="painel">
  		<img src="estoque.jpeg">
		<h5>INVENTORY TRACKER</h5>
	<div class="loginform">

		<h1>   Ol�, seja bem vindo!</h1>
		<h3>   Efetue o login para continuar</h3>

		<form action="index" method="post">
			<div class="loginemail">
				<label for="email" class="lbl"></label> <input
					class="inputlogin" type="text" id="email" name="email"
					placeholder="Digite seu email">
			</div>
			<div class="loginsenha">
				<label for="senha" class="lbl"></label> <input
					class="inputlogin" type="password" id="senha" name="senha"
					placeholder="Digite sua senha">
			</div>
			<input type="submit" id="btn" name="btn" value="Entrar">
			
		</form>
	</div>
			</div>
</body>
</html>