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
<body style="background: #E5E7E9">

	<nav class="navbar navbar-inverse navbar-fixed-top" style="margin-bottom:20px";>
		<div class="container">
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item"><a class="nav-link active" id="home-tab"
					data-toggle="tab" href="${contextPath}/livro" role="tab"
					aria-controls="home" aria-selected="true">Home</a></li>
			</ul>
		</div>
		
	</nav>

	<div class="container border border-dark" style="margin-bottom:30px">

		<h1 style="text-align: center;margin-bottom:50px;"  >${livro.titulo}</h1>
			
			
			<p style="margin:30px 20px;padding:10px;background: #fff;border-radius:10px"><span class="font-weight-bold">Autor do livro </span> : ${livro.nomeAutor}</p>
		
		
			<p style="margin:30px 20px;padding:10px;background: #fff;border-radius:10px"><span class="font-weight-bold">Data </span> : ${livro.data}</p>
		
		
			<p style="margin:30px 20px;padding:10px;background: #fff;border-radius:10px"><span class="font-weight-bold">Pre?o </span> : R$ ${livro.preco}</p>
		
		
			<p style="margin:30px 20px;padding:10px;background: #fff;border-radius:10px"><span class="font-weight-bold">G?nero </span> : ${livro.genero}</p>
		
		
			<p style="margin:30px 20px;padding:10px;background: #fff;border-radius:10px"><span class="font-weight-bold">Sinopse </span> : ${livro.sinopse}</p>
		
		<div class="text-center">
			<a href="${contextPath}/livro" style="margin: 20px 0"
				class="btn btn-danger btn-lg">Volta a Pagina inicial</a>
		</div>
		
	</div>

	<!-- Bootstrap -->
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>