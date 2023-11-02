<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href='<c:url value="./resources/css/style.css" />'>
<meta charset="ISO-8859-1">
<title>Produto</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
		<br />
	</div>
	<div>
		<form action="produto" method="post">
			<table>
				<tr>
					<td colspan="3"><input type="number" id="codigo" name="codigo"
						placeholder="Código" value='${produto.codigo }'></td>
					<td><input type="submit" value="Consultar" id="button"
						name="button"></td>
				</tr>
				<tr>
					<td colspan="4"><input type="text" id="nome" name="nome"
						placeholder="Nome" value='${produto.nome }'></td>
				</tr>
				<tr>
					<td colspan="4"><input type="number" id="quantidade"
						name="quantidade" placeholder="Quantidade"
						value='${produto.quantidade }'></td>
				</tr>
				<tr>
					<td colspan="4"><input type="date" id="vencimento"
						name="vencimento" placeholder="Vencimento"
						value='${produto.vencimento }'></td>
				</tr>
				<tr>
					<td colspan="4"><input type="text" id="marca" name="marca"
						placeholder="Marca" value='${produto.marca }'></td>
				</tr>

				<tr>
					<td colspan="4"><input type="text" id="categoria"
						name="categoria" placeholder="Categoria"
						value='${produto.categoria }'></td>
				</tr>

				<tr>
					<td colspan="4"><input type="text" id="cnpjFornecedor"
						name="cnpjFornecedor" placeholder="cnpjFornecedor"
						value='${produto.cnpjFornecedor }'></td>
				</tr>

				<tr>
					<td colspan="4"><input type="text" id="nomeFornecedor"
						name="nomeFornecedor" placeholder="nomeFornecedor"
						value='${produto.nomeFornecedor }'></td>
				</tr>

				<tr>
					<td colspan="4"><input type="date" id="dataCompra"
						name="dataCompra" placeholder="dataCompra"
						value='${produto.dataCompra }'></td>
				</tr>

				<tr>
					<td colspan="4"><input type="number" step="0.01"
						id="valorUnitario" name="valorUnitario"
						placeholder="Valor Unitário" value='${produto.valorUnitario }'></td>
				</tr>
				<tr>
					<td colspan="4"><input type="text" id="descricao"
						name="descricao" placeholder="Descricao"
						value='${produto.descricao }'></td>
				</tr>
				<tr>
					<td><input type="submit" value="Cadastrar" id="button"
						name="button"></td>
					<td><input type="submit" value="Atualizar" id="button"
						name="button"></td>
					<td><input type="submit" value="Excluir" id="button"
						name="button"></td>
					<td><input type="submit" value="Listar" id="button"
						name="button"></td>
				</tr>
			</table>
		</form>
	</div>
	<div>
		<c:if test="${not empty saida }">
			<p>
				<c:out value="${saida }" />
			</p>
		</c:if>
		<c:if test="${not empty erro }">
			<H2 style="color: red">
				<c:out value="${erro }" />
			</H2>
		</c:if>
	</div>
	<div>
		<br />
		<c:if test="${not empty listaProdutos }">
			<table border=1>
				<thead>
					<tr>
						<th>Código</th>
						<th>Nome</th>
						<th>Quantidade</th>
						<th>Vencimento</th>
						<th>Marca</th>
						<th>Categoria</th>
						<th>CNPJ Fornecedor</th>
						<th>Nome Fornecedor</th>
						<th>Data de Compra</th>
						<th>Valor Unitário</th>
						<th>Descrição</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${listaProdutos }">
						<tr>
							<td>${p.codigo }</td>
							<td>${p.nome }</td>
							<td>${p.quantidade }</td>
							<td>${p.vencimento }</td>
							<td>${p.marca }</td>
							<td>${p.categoria }</td>
							<td>${p.cnpjFornecedor }</td>
							<td>${p.nomeFornecedor }</td>
							<td>${p.dataCompra }</td>
							<td>${p.valorUnitario }</td>
							<td>${p.descricao }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>