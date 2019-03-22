<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Create new Employee</title>
	<link rel="stylesheet" type="text/css" href="/resources/style.css">
</head>
<body>
	<h2>Create new Employee</h2>
	<p><a href="/">&lt;- Back to main page</a></p>
	<form action="/employees/create" method="post">
		Employee name:<br>
		<input type="text" name="name"><br><br>
		Employee skill:<br>
		<input type="text" name="skill"><br><br>
		Department:<br>
		<select name="department_id">
			<c:forEach items="${departments}" var="department">
				<option value="${department.id}">${department.name}</option>
			</c:forEach>
  		</select><br><br>
  		<input type="submit" value="Create">
	</form>
</body>
</html>