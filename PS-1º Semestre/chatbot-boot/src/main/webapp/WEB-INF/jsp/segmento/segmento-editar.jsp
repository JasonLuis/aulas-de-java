<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
	<title>Editar - Segmento</title>
    <c:set value="${pageContext.request.contextPath}" var="contextPath"/>
    <link rel="stylesheet" href="${contextPath}/css/style.css">
</head>

<body>
	<header class="cabecalho">
		<div class="cabecalho-menu">
			<a href="#"><img class="logo-principal" src="${contextPath}/fonts/download.jfif"></a>
			<nav class="navegacao">
				<ul>
					<a href="${contextPath}/chatbot"><li>Home</li></a>
					<a href="${contextPath}/chatbot/form?page=chatbot-novo"><li>Chatbot</li></a>
					<a href="${contextPath}/segmento"><li>Segmentos</li></a>
				</ul>
			</nav>
		</div>
	</header>
	<main class="conteudo-principal">

		<form:form class="form-insert" modelAttribute="segmentoModel" action="${contextPath}/segmento/${segmentoModel.idSegment}" method="put">
			<spring:hasBindErrors name="segmentoModel">
				<div class="alert alert-danger" role="alert">
					<form:errors path="*" class="has-error" />
				</div>
			</spring:hasBindErrors>

			<h2>Cadastro de Segmentos de Conversação</h2>
			<label for="name">Nome:</label>
			<form:input name="name" path="name" id="name"
				placeholder="Digite o nome da Sequencia de Conversação" />
			<button type="submit" class="botao-gravar">Salvar</button>
		</form:form>
	</main>
</body>
</html>