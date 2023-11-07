<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href='<c:url value="./resources/css/styles.css" />'>
<meta charset="ISO-8859-1">
<title>Estoque</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
		<br />
	</div>
	<div>
		<div>
			<form action="estoque" method="post">
				<table>
					<tr>
						<td><input type="submit" value="Listar" id="button"
							name="button"></td>
					</tr>
				</table>
			</form>
		</div>
		<c:if test="${not empty listaEstoque }">
			<p>Lista de Produto no Estoque:</p>
			<table border=1>
				<thead>
					<tr>
						<th>Código</th>
						<th>Nome</th>
						<th>Vencimento</th>
						<th>Marca</th>
						<th>CNPJ do Fornecedor</th>
						<th>Nome do Fornecedor</th>
						<th>Quantidade em Estoque</th>
						<th>Valor Unitário</th>
						<th>Nível de Estoque</th>
						<th>Valor Total do Item</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${listaEstoque }">
						<tr class="est">
							<td>${p.codigo }</td>
							<td>${p.nome }</td>
							<td>${p.vencimento }</td>
							<td>${p.marca}</td>
							<td>${p.cnpjFornecedor }</td>
							<td>${p.nomeFornecedor }</td>
							<td>${p.quantidade}</td>
							<td>${p.valorUnitario }</td>
							<td>${p.nivel }</td>
							<td>${p.valorTotal }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

	</div>
</body>
</html>