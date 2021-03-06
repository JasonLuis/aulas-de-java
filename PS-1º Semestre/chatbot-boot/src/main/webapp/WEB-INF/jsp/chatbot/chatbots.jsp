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
<title>Lista de Bots</title>
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
		</div>/
	</header>
	<main class="conteudo-principal">
		
		<ul class="lista-bot">
			<c:if test="${not empty messages}">
				<h1>${messages}</h1>
			</c:if>
			<c:forEach items="${chatbots}" var="chatbot">
				<li>
					<h2>${chatbot.name}</h2>
					<img alt="Imagem do Bot" src="${contextPath}/fonts/robot.svg" >
					<p>${chatbot.segmento}</p>
					<form:form action="${contextPath}/chatbot/${chatbot.idBot}" method="delete" class="form-lista">
						<a href="${contextPath}/chatbot/${chatbot.idBot}"><button type="button" class="botao-detalhes">Detalhes</button></a>
						<a href="${contextPath}/chatbot/form?page=chatbot-editar&id=${chatbot.idBot}"><button type="button" class="botao-editar">Editar</button></a>
						<button id="btnExcluir" type="submit" class="botao-excluir">Excluir</button>
					</form:form>
				</li>
			</c:forEach>
		</ul>
	</main>
</body>
</html>