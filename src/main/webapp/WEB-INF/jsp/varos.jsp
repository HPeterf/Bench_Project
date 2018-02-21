<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>

<head>
</head>

<body>
<form action = "varosInfo" method="post">
		<b>See current weather in city:</b>
		<br>

		<input type="text" name="cityName" required />
		<p>
			<input type="submit" name="Submit" value="See current weather" />
		</p>

	</form>
	
</body>
</html>