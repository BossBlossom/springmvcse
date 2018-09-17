<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<spring:url value='/resources/css/app.css'/>">
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
</head>
<body>
<a onclick="window.location.href='<spring:url value="/m-todo" />'"><h4>M-TODO</h4></a>
<table class="tbl-border">
	<tr>
		<th>No.</th>
		<th>Name</th>
		<th>Status</th>
		<th>Start Date</th>
		<th>Start At</th>
		<th>End At</th>
		<th colspan="3">Actions</th>
	<tr>
	<tbody>
		<% int i = 1; %>
		<c:forEach var="m_todo" items="${todos}">
		<tr>
			<td><%=i++ %></td>
			<td>${m_todo.name }</td>
			<td>${m_todo.status }</td>
			<td>${m_todo.startDate }</td>
			<td>${m_todo.startAT }</td>
			<td>${m_todo.endAT }</td>
	</c:forEach>
	</tbody>
</table>
<div class="action">
	<button type="button" onclick="window.location.href='<spring:url value="/m-todo/create" />'">CREATE</button>
</div>
</body>
</html>