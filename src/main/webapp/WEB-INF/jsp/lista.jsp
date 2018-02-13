<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
</head>

<body>
	<table border="1" width="50%">

		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Date</th>
		</tr>

		<c:forEach items="${names}" var="names">
			<tr>
				<td><c:out value="${names.id}" /></td>
				<td><c:out value="${names.name}" /></td>
				<td><c:out value="${names.date}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>

<br>
<br>

<a href="/add">New record</a>

</html>