<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang="nl">
<head>
<link rel='icon' href='<c:url value="/images/favicon.ico"/>'>
<meta name='viewport' content='width=device-width,initial-scale=1'>
<link rel='stylesheet' href='<c:url value="/styles/default.css"/>'>
<title>Werknemer ${werknemer.getNaam()}</title>
</head>
<body>
	<h1>Werknemer ${werknemer.getNaam()}</h1>
	<dl>
		<dt>Voornaam</dt>
		<dd>${werknemer.voornaam}</dd>
		<dt>Familienaam</dt>
		<dd>${werknemer.familienaam}</dd>
		<dt>Email adres</dt>
		<dd>${werknemer.email}</dd>
		<dt>Salaris</dt>
		<dd>&euro; <spring:eval expression="werknemer.salaris"/></dd>
		<dt>Jobtitel</dt>
		<dd>${werknemer.jobtitel.naam}</dd>
		<c:if test="${not empty werknemer.chef }">
			<dt>Chef</dt>
			<spring:url var="url" value="/werknemer/{id}">
				<spring:param name="id" value="${werknemer.chef.id}"/>
			</spring:url>
			<dd><a href="${url}">${werknemer.chef.getNaam()}</a></dd>
		</c:if>
		<c:if test="${not empty werknemer.ondergeschikten}">
			<dt>Ondergeschikten</dt>
			<c:forEach items="${werknemer.ondergeschikten}" var="ondergeschikt">
				<spring:url var="url" value="/werknemer/{id}">
					<spring:param name="id" value="${ondergeschikt.id}"/>
				</spring:url>
				<dd><a href="${url}">${ondergeschikt.getNaam()}</a></dd>
			</c:forEach>
		</c:if>
		<dt>Foto</dt>
	</dl>
	<img alt='${werknemer.voornaam} ${werknemer.familienaam}' 
			src="<c:url value='/images/${werknemer.id}.jpg'/>">
	<spring:url value="/werknemer/{id}/opslag" var="opslagURL">
		<spring:param name="id" value="${werknemer.id}"/>
	</spring:url>
	<form action="${opslagURL}">
		<input type="submit" value="Opslag">
	</form>
</body>
</html>
