<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Spring Demo: Company Database</title>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
	<link rel="stylesheet" type="text/css" href="/resources/style.css">
</head>
<body>
	<div class="content">
		<h1>Company Database</h1>
		<p><a href="/seed">Seed database</a></p>
		<h2>Departments</h2>
		<p><a href="/departments/create">Create a new Department</a></p>
		<table id="dep-table">
			<thead>
				<tr>
					<th>ID</th><th>Name</th><!-- <th>Amount of Employees</th> --><th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${departments}" var="department">
					<tr class="<c:if test="${selected_dep_ids.contains(department.id)}">selected</c:if>">
						<td>${department.id}</td>
						<td>${department.name}</td>
						<%-- <td>${department.employees.size()}</td> --%>
						<td>
							<a href="/departments/edit/${department.id}">Edit</a>
							<a href="/departments/delete/${department.id}">Delete</a>
							<input type="checkbox" name="department_id" value="${department.id}" class="department-checkbox">
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<h2>Employees</h2>
		<p><a href="/employees/create">Create a new Employee</a></p>
		<table id="emp-table">
			<thead>
				<tr><th>ID</th><th>Name</th><th>Skill</th><th>Department Name</th><th>Actions</th><th class="hidden"></th></tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="employee">
					<tr>
						<td>${employee.id}</td>
						<td>${employee.name}</td>
						<td>${employee.skill}</td>
						<td>${employee.department.name}</td>
						<td>
							<a href="/employees/edit/${employee.id}">Edit</a> 
							<a href="/employees/delete/${employee.id}">Delete</a>
						</td>
						<td class="hidden">${employee.department.id}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
	<script src="/resources/script.js"></script>
</body>
</html>