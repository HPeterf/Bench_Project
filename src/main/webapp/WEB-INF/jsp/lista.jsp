<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

	<body>
	<table border="1" width="50%">
		<tr>
			<th>ID</th>
			<th>Name</th>
		</tr>
		<c:forEach items="${names}" var="name">
			<tr>
				<td><c:out value="${names.id}" /></td>
				<td><c:out value="${names.name}" /></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
<br><br>
<a href="/add">New Record</a>

</html>