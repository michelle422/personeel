<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang="nl">
<head>
<link rel='icon' href='<c:url value="/images/favicon.ico"/>'>
<meta name='viewport' content='width=device-width,initial-scale=1'>
<link rel='stylesheet' href='<c:url value="/styles/default.css"/>'>
<title>Personeel</title>
</head>
<body>
	<h1>Menu</h1>
	<ul>
		<li><a href='<c:url value="/werknemer"/>'>Werknemershiërarchie</a></li>
		<li><a href='<c:url value="/jobtitels"/>'>Jobtitels</a></li>
	</ul>
</body>
</html>
