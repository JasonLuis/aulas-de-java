<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalhes</title>
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
					data-toggle="tab" href="${contextPath}/livro" role="tab"
					aria-controls="home" aria-selected="true">Home</a></li>
			</ul>
		</div>
	</nav>

	<div class="container" style="background: #BED5EC; margin-top: 15px;">

		<h1>${livro.titulo}</h1>
		<p class="font-weight-bold">${livro.nomeAutor}</p>
		<p class="font-weight-bold">${livro.data}</p>
		<p class="font-weight-bold">R$ ${livro.preco}</p>
		<p class="font-weight-bold">${livro.genero}</p>
		<p class="font-weight-bold">${livro.sinopse}</p>
		<a href="${contextPath}/livro" class="btn btn-danger btn-sm">Volta
			a Pagina inicial</a>
	</div>

	<!-- Bootstrap -->
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>