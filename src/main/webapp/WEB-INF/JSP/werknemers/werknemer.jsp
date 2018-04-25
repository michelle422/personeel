<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang="nl">
<head>
<title>Werknemer ${werknemer.voornaam + " " + werknemer.familienaam}</title>
</head>
<body>
	<h1>Werknemer ${werknemer.voornaam + " " + werknemer.familienaam}</h1>
	<dl>
		<dt>Voornaam</dt>
		<dd>>${werknemer.voornaam}</dd>
		<dt>Familienaam</dt>
		<dd>${werknemer.familienaam}</dd>
		<dt>Email adres</dt>
		<dd>${werknemer.email}</dd>
		<dt>Salaris</dt>
		<dd>&euro; <spring:eval expression="werknemer.salaris"/></dd>
		<dt>Foto</dt>
		<img alt='${werknemer.voornaam + " " + werknemer.familienaam}' 
			src="<c:url value='/images/${werknemer.id}.jpg'/>" class="fullwidth">
	</dl>
</body>
</html>