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
<title>Lista de Segmentos</title>
<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<link rel="stylesheet" href="${contextPath}/css/style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
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
			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Nome do Segmento</th>
						<th scope="col">Op??es</th>
					</tr>
				</thead>
				<tbody>
					<p class="toolbar" style="margin-top: 10px;">
						<a href="${contextPath}/segmento/form?page=segmento-novo">
							<button class="class="btnbtn-primary"">NovoSegmento</button>
						</a>
					</p>
					<h1>Lista de Segmentos</h1>

					<c:if test="${not empty messages}">
						<h3 class="alert alert-warning">${messages}</h3>
					</c:if>

					<c:forEach items="${segmentos}" var="segmento">
						<tr>
							<th scope="row">${segmento.idSegment}</th>
							<td>${segmento.name}</td>
							<td class="actions"><form:form
									action="${contextPath}/segmento/${segmento.idSegment}"
									method="delete">
									<a class="btn btn-warning btn-xs"
										href="${contextPath}/segmento/form?page=segmento-editar&id=${segmento.idSegment}">Editar</a>
									<button type="submit" class="btn btn-danger btn-xs">Excluir</button>
								</form:form></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</main>
</body>
</html>

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous">
	
</script>
</body>
</html>