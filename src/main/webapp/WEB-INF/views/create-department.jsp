<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Create new Department</title>
	<link rel="stylesheet" type="text/css" href="/resources/style.css">
</head>
<body>
	<h2>Create new Department</h2>
	<p><a href="/">&lt;- Back to main page</a></p>
	<form action="/departments/create" method="post">
		Department name:<br>
		<input type="text" name="name"><br><br>
		<%-- Head of department:<br>
		<select name="head_id">
			<c:forEach items="${employees}" var="employee">
				<option value="${employee.id}">${employee.name}</option>
			</c:forEach>
  		</select><br><br> --%>
  		<input type="submit" value="Create">
	</form>
</body>
</html>