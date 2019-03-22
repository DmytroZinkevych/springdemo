<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Department</title>
	<link rel="stylesheet" type="text/css" href="/resources/style.css">
</head>
<body>
	<h2>Edit Department</h2>
	<p><a href="/">&lt;- Back to main page</a></p>
	<form action="/departments/edit" method="post">
		<input type="hidden" name="id" value="${department.id}">
		Department name:<br>
		<input type="text" name="name" value="${department.name}"><br><br>	
		<%-- Head of department:<br>
		<select name="head_id">
			<c:forEach items="${employees}" var="employee">
				<option value="${employee.id}"
					<c:if test = "${employee.id == department.head.id}">
				         selected
					</c:if>
				>${employee.name}</option>
			</c:forEach>
  		</select><br><br> --%>
		<input type="submit" value="Edit">
	</form>
</body>
</html>