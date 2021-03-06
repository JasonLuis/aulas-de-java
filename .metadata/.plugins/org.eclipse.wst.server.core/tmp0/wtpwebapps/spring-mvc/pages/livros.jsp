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
<link href="${css}/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Titulo</th>
					<th scope="col">Pre?o</th>
					<th scope="col">Genero</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${livros}" var="livro">
					<tr>
						<th scope="row">livro.id</th>
						<td>${livro.titulo}</td>
						<td>${livro.preco}</td>
						<td>${livro.genero}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
		<!-- Bootstrap -->
		<script src="${js}/bootstrap.min.js"></script>
</body>
</html>