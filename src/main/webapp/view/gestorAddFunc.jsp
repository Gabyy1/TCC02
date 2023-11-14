<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href='<c:url value="./resources/css/style.css" />'>
<meta charset="ISO-8859-1">
<title>Adicionar Funcionarios</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
		<br />
	</div>
		<div>
		<form action="gestorAddFunc" method="post">
		</form>
		</div>
	<header>
		<a class="btn-voltar" href="gestor"> <img class="icon-voltar"
			src='<c:url value="./resources/back.svg" />'>
		</a> <span>Adicionar Profissionais</span> <img
			src='<c:url value="./resources/logo-branco.svg" />'>
	</header>
	<div class="content">
		<div>
			<h1>Preencha os dados para adicionar o funcionario.</h1>
		</div>
		<div>
			<form action="gestorAddFunc" method="post">
				<div class="form">
					<div class="form-fields">
						<label for="cpf">CPF</label> <input type="text" id="cpf"
							name="cpf" placeholder="Digite o cpf">
					</div>

					<div class="form-fields">
						<label for="nome">Nome</label> <input type="text" id="nome"
							name="nome" placeholder="Digite o nome">
					</div>

					<div class="form-fields">
						<label for="email">Email</label> <input type="text" id="email"
							name="email" placeholder="Digite o email">
					</div>

					<div class="form-fields">
						<label for="senha">Senha</label> <input type="password" id="senha"
							name="senha" placeholder="Digite a senha">
					</div>

					<div class="form-fields">
						<select id="cargo" name="cargo">
							<option value="0">Escolha o cargo</option>
							<option value="02">Estoquista</option>
							<option value="03">Atendente</option>
						</select>
					</div>


					<button class="btn-form" type="submit" id="botao" name="botao"
						value="Adicionar funcionario">Adicionar profissional</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>