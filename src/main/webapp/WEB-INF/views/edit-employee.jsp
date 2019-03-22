<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Employee</title>
	<link rel="stylesheet" type="text/css" href="/resources/style.css">
</head>
<body>
	<h2>Edit Employee</h2>
	<p><a href="/">&lt;- Back to main page</a></p>
	<form action="/employees/edit" method="post">
		<input type="hidden" name="id" value="${employee.id}">
		Employee name:<br>
		<input type="text" name="name" value="${employee.name}"><br><br>	
		Employee skill:<br>
		<input type="text" name="skill" value="${employee.skill}"><br><br>
		Department:<br>
		<select name="department_id">
			<c:forEach items="${departments}" var="department">
				<option value="${department.id}"
					<c:if test = "${department.id == employee.department.id}">
				         selected
					</c:if>
				>${department.name}</option>
			</c:forEach>
  		</select><br><br>
		<input type="submit" value="Edit">
	</form>
</body>
</html>