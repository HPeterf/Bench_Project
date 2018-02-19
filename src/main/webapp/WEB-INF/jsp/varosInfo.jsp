<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
</head>

<body>

	<b>Current weather:</b>
	<br>
	<p>
		<c:out value="${error}" />
	</p>
	<p>
		<c:out value="${result}" />
	</p>
	<br>
	<a href="/varos">Check another city</a>

</body>

</html>