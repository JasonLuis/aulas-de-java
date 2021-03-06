<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nac Livros</title>
<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/js" var="js" />
<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<link href="${css}/style.css" rel="stylesheet">
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item"><a class="nav-link active" id="home-tab"
					data-toggle="tab" href="${contextPath}/livro" role="tab" aria-controls="home"
					aria-selected="true">Home</a></li>
			</ul>
		</div>
	</nav>
	
	<div class="container">
		<div class="row">
			<h1>Biblioteca Fiap</h1>
		</div>
		
		<div class="row">
			<a class="btn btn-outline-secondary btn-lg" href="${contextPath}/livro/form?page=new-livros">Cadastrar</a>
		</div>
		
		<div class="row">	
			<c:if test="${not empty messages}">
				<h3 style="margin-top: 10px;" class="alert alert-warning">${messages}</h3>
			</c:if>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Titulo</th>
						<th scope="col">Pre?o</th>
						<th scope="col">Genero</th>
						<th scope="col">Op??es</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${livro}" var="livro">
						<tr>
							<td>${livro.titulo}</td>
							<td>${livro.preco}</td>
							<td>${livro.genero}</td>
							<td>
								<form:form action="${contextPath}/livro/${livro.id}" method="delete">
									<a class="btn btn-success" href="${contextPath}/livro/${livro.id}">Detalhes</a>
									<a class="btn btn-warning" href="${contextPath}/livro/form?page=update-livros&id=${livro.id}">Editar</a>
									<input type="submit" value="Excluir" class="btn btn-danger btn-xs">
								</form:form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- Bootstrap -->
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>