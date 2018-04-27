<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang="nl">
<head>
<link rel='icon' href='<c:url value="/images/favicon.ico"/>'>
<meta name='viewport' content='width=device-width,initial-scale=1'>
<link rel='stylesheet' href='<c:url value="/styles/default.css"/>'>
<title>Jobtitels</title>
</head>
<body>
	<h1>Jobtitels</h1>
	<ul class="zonderbolletjes">
		<c:forEach items="${jobtitels}" var="jobtitel">
			<spring:url var="url" value="/jobtitels/{id}">
				<spring:param name="id" value="${jobtitel.id}"/>
			</spring:url>
			<li><a href="${url}">${jobtitel.naam}</a></li>
		</c:forEach>
	</ul>
	<c:if test="${not empty werknemers}">
		<h1>${jobtitel.naam}</h1>
		<ul>
			<c:forEach items="${werknemers}" var="werknemer">
				<spring:url var="url" value="/werknemer/{id}">
					<spring:param name="id" value="${werknemer.id}"/>
				</spring:url>
				<li><a href="${url}">${werknemer.voornaam} ${werknemer.familienaam}</a></li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>
