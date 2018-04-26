<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang="nl">
<head>
<title>Jobtitels</title>
</head>
<body>
	<h1>Jobtitels</h1>
	<ul>
		<c:forEach items="${jobtitels.naam}" var="naam">
			<li class="zonderbolletjes">${naam}</li>
		</c:forEach>
	</ul>
</body>
</html>
