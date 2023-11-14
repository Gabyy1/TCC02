<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Inventory Tracker | Gestor</title>
</head>
<body>
<div>
		<jsp:include page="menu.jsp" />
		<br />
	</div>
	<header>
		<div class="gheader">
			<span>Olá, seja bem vindo!</span> <a class="btn-sair" href="index"
				onclick="return confirm('Tem certeza que deseja sair?')"> <img
				class="icon-sair" src='<c:url value="./resources/sair.svg" />'>
			</a>
		</div>
	</header>
	<div class="content">
		<div>
			<h1>Painel de Funcionários</h1>
			<a class="btn-add" href="gestorAddFunc"> <img
				class="icon-btnadd" src='<c:url value="./resources/plus.svg" />'>
				Adicionar funcionario
			</a>
		</div>
		<div class="tables">
			<div>
				<div class="funcionario">
					<h2>Funcionários</h2>
					<form action="gestor" method="post">
						<div class="busca">
							<input type="text" class="barra-pesquisa" id="ba" name="ba"
								placeholder="Pesquise o funcionario">
							<button type="submit" class="btn-pesquisa" id="botao"
								name="botao" value="buscar funcionario">
								<img class="icon-search"
									src='<c:url value="./resources/search.svg" />'>
							</button>
						</div>
					</form>
				</div>

				<c:if test="${not empty funcionario}">
					<table>
						<thead>
							<tr>
								<th>CPF</th>
								<th>Nome</th>
								<th>Email</th>
								<th>Cargo</th>
								<th>Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${funcionario }" var="f">
								<tr>
									<td><c:out value="${f.cpf }"></c:out></td>
									<td><c:out value="${f.nome }"></c:out></td>
									<td><c:out value="${f.email }"></c:out></td>
									<td><c:out value="${f.cargo }"></c:out></td>
									<td><a class="btn-edit"
										href="<c:url value='/editFuncionario/${f.cpf}'/>"><img
											class="icon-edit" src='<c:url value="./resources/pen.svg" />'></a>
										<a class="btn-remove"
										href="<c:url value='/deleteFuncionario/${f.cpf}/${f.email }'/>"
										onclick="return confirm('Tem certeza que deseja excluir?')">
											<img class="icon-edit"
											src='<c:url value="./resources/trash.svg" />'>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>