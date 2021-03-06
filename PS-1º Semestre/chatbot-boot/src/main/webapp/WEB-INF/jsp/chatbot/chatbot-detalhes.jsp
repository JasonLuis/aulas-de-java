<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalhes Chatbot</title>
<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<link rel="stylesheet" href="${contextPath}/css/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<header class="cabecalho">
		<div class="cabecalho-menu">
			<a href="#"><img class="logo-principal"
				src="${contextPath}/fonts/download.jfif"></a>
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
		<div class="container">
			<h1 style="margin-top: 80px" class="text-center font-weight-bold">${chatbot.name}</h1>
			
			<p class="text-center">
				<img style="width: 300px; height: 300px;" alt="Imagem do Bot" src="${contextPath}/fonts/robot.svg" >
			</p>
			<h2>
				<span class="font-weight-bold">Mensagem de Boas Vindas: </span>
				${chatbot.welcome_msg}
			</h2>
			<h2>
				<span class="font-weight-bold">Mensagem final: </span>
				${chatbot.farewell_msg}
			</h2>
			<h2>
				<span class="font-weight-bold">Tempo de Resposta: </span>
				${chatbot.downtime}
			</h2>
			<h2>
				<span class="font-weight-bold">Mensagem Default: </span>
				${chatbot.default_answer}
			</h2>
			<h2>
				<span class="font-weight-bold">Segmentos de Conversa??o: </span>
				<c:if test="${empty chatbot.segmento}">
					N?o possui
				</c:if>
				<c:if test="${not empty chatbot.segmento}">
					${chatbot.segmento}
				</c:if>
			</h2>
		</div>
		
	</main>
</body>
</html>