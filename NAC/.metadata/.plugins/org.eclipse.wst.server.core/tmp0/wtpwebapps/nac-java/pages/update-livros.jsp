<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edi??o de Livros</title>
<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/js" var="js" />
<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<link href="${css}/style.css" rel="stylesheet">
</head>
<body style="background: #E5E7E9">
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item"><a class="nav-link active" id="home-tab"
					data-toggle="tab" href="${contextPath}/livro" role="tab"
					aria-controls="home" aria-selected="true">Home</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="well">
					<br>
					<br>
					<h2>Edi??o de Livros</h2>
					<form:form modelAttribute="livroModel"
						action="${contextPath}/livro/${livroModel.id}" method="put">
						<spring:hasBindErrors name="livroModel">
							<div class="alert alert-danger" role="alert">
								<form:errors path="*" class="has-error" />
							</div>
						</spring:hasBindErrors>

						<div class="form-group">
							<label class="control-label" for="titulo">Titulo:</label>
							<form:input type="text" path="titulo" id="titulo"
								class="form-control" maxlength="50" size="50" />
							<font color="red"><form:errors path="titulo" /></font><br />
						</div>

						<div class="form-group">
							<label class="control-label" for="nomeAutor">Nome do
								Autor:</label>
							<form:input type="text" path="nomeAutor" id="nomeAutor"
								class="form-control" maxlength="50" size="50" />
							<font color="red"><form:errors path="nomeAutor" /></font><br />
						</div>

						<div class="form-group">
							<label class="control-label" for="data">Data de
								lan?amento:</label>
							<form:input type="text" path="data" id="data"
								class="form-control" maxlength="50" size="50" />
							<font color="red"><form:errors path="data" /></font><br />
						</div>

						<div class="form-group">
							<label class="control-label" for="preco">Pre?o:</label>
							<form:input type="text" path="preco" id="preco"
								class="form-control" maxlength="50" size="50" />
							<font color="red"><form:errors path="preco" /></font><br />
						</div>

						<div class="form-group">
							<label class="control-label" for="genero">Genero:</label>
							<form:input type="text" path="genero" id="genero"
								class="form-control" maxlength="50" size="50" />
							<font color="red"><form:errors path="genero" /></font><br />
						</div>

						<div class="form-group">
							<label class="control-label" for="sinopse">Sinopse:</label>
							<form:textarea path="sinopse" id="sinopse"
								class="form-control" maxlength="50" size="500" />
							<font color="red"><form:errors path="sinopse" /></font><br />
						</div>
						<a class="btn btn-danger btn-lg" href="${contextPath}/livro">Cancelar</a>
						<button type="submit" class="btn btn-success btn-lg">Salvar Edi??o</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script src="${js}/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${js}/bootstrap.min.js"></script>

</body>
</html>