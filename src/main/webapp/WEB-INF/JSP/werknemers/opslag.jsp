<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html lang="nl">
<head>
<link rel='icon' href='<c:url value="/images/favicon.ico"/>'>
<meta name='viewport' content='width=device-width,initial-scale=1'>
<link rel='stylesheet' href='<c:url value="/styles/default.css"/>'>
<title>Opslag voor ${werknemer.voornaam} ${werknemer.familienaam}</title>
</head>
<body>
	<h1>Opslag voor ${werknemer.voornaam} ${werknemer.familienaam}</h1>
	<dl>
		<dt>Huidige salaris</dt>
		<dd>&euro; <spring:eval expression="werknemer.salaris"/></dd>
	</dl>
	<spring:url value="/werknemer/{id}/opslag" var="opslagURL">
		<spring:param name="id" value="${werknemer.id}"/>
	</spring:url>
	<form:form commandName="opslagForm">
		<form:label path="bedrag">Bedrag<form:errors path="bedrag"/></form:label><br>
		<form:input path="bedrag" autofocus="autofocus" required="required"/><br>
		<input type="submit" value="Opslag">
	</form:form>
</body>
</html>
