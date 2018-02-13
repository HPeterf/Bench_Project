<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<body>
	<b>Result:</b>
	<br>
	<p>
		<c:out value="${result}" />
	</p>
	<p>
		<c:out value="${error}" />
	</p>
	<br>
	<a href="/add">New record</a>
	<br>

	<br>
	<a href="/lista">Full list Page</a>

</body>

</html>