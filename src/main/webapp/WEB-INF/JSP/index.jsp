<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang="nl">
<head>
<title>Personeel</title>
</head>
<body>
	<h1>Menu</h1>
	<nav>
		<ul>
			<li><a href='<c:url value="/werknemers"/>'>Werknemershiërarchie</a></li>
			<li><a href='<c:url value="/jobtitels"/>'>Jobtitels</a></li>
		</ul>
	</nav>
</body>
</html>
