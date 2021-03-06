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
	<title>Editar Chatbot</title>
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

		<form:form class="form-insert" modelAttribute="chatbotModel" action="${contextPath}/chatbot/${chatbotModel.idBot}" method="put">
			<spring:hasBindErrors name="chatbotModel">
				<div class="alert alert-danger" role="alert">
					<form:errors path="*" class="has-error" />
				</div>
			</spring:hasBindErrors>

			<h2>Cadastro de Bots</h2>
			<label for="name">Nome:</label>
			<form:input name="name" path="name" id="name"
				placeholder="Digite o nome do Bot" />

			<div class="style-select">
				<label for="segmento">Segmentos:</label>
				<form:select class="select-css" multiple="true" path="segmento">
					<form:options items="${segmentos}" itemValue="idSegment"
						itemLabel="name" />
				</form:select>
			</div>

			<label for="welcome">Mensagem de boas-vindas:</label>
			<form:input type="text" path="welcome_msg" name="welcome"
				id="welcome" placeholder="Digite a mensagem de boas-vindas" />

			<label for="farewell">Mensagem de final:</label>
			<form:input type="text" path="farewell_msg" name="farewell"
				id="farewll" placeholder="Digite a mensagem final" />

			<label for="downtime">Tempo:</label>
			<form:input type="number" path="downtime" name="downtime"
				id="downtime" placeholder="Digite o tempo" />

			<label for="default">Mensagem de Default:</label>
			<form:input type="text" path="default_answer" name="default"
				id="default" placeholder="Digite a mensagem final" />

			<button type="submit" class="botao-gravar">Salvar Altera??es</button>
		</form:form>
	</main>
</body>
</html>