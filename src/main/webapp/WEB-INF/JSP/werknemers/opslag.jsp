<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html lang="nl">
<head>
<title>Opslag voor ${werknemer.getNaam()}</title>
</head>
<body>
	<h1>Opslag voor ${werknemer.getNaam()}</h1>
	<dl>
		<dt>Huidige salaris</dt>
		<dd>&euro; <spring:eval expression="werknemer.salaris"/></dd>
	</dl>
	<spring:url value="/werknemer/{id}/opslag" var="opslagURL">
		<spring:param name="id" value="${werknemer.id}"/>
	</spring:url>
	<form:form method="post" action="${opslagURL}" commandName="werknemer" id="opslagform">
		<form:label path="salaris">Bedrag<form:errors path="salaris"/></form:label><br>
		<form:input path="salaris" autofocus="autofocus" required="required"/><br>
		<input type="submit" value="Opslag" id="submitknop">
		<script>
			document.getElementById('opslagform').onsubmit=function() {
				document.getElementById('submitknop').disabled = true;
			};
		</script>
	</form:form>
</body>
</html>
