<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>

	<body>
	<h1> Felvitt nevek: </h1>
	<table class="tg">
	<tr>
		<th width="80">Name</th>
	</tr>
	
	<c:forEach items="${listAllNames}" var="names">
		<tr>
			<td>${names.name}</td>
		</tr>
	</c:forEach>
	
	</table>
	
</body>
<br><br>
<a href="/add">New Record</a>

</html>