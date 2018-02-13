<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>

<head>
</head>

<body>
	<h1>Név Bevitel:</h1>
	<c:url var=addName value="/add"></c:url>

	<form:form action="${addAction}" commandName="names">
		<table>
			<tr>
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" reqired=true /></td>

			</tr>
			<tr>
				<input type="submit" value="<spring:message text="Submit"/>" />
			</tr>
		</table>

	</form:form>

	<br>
	<br>
	<br>
	<a href="/lista">Full List Page</a>

</body>
</html>