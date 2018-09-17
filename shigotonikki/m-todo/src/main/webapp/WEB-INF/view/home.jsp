<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<spring:url value='/resources/css/app.css'/>">
</head>
<body>
<a onclick="window.location.href='<spring:url value="/home" />'"><h4>M-TODO</h4></a>
<table class="tbl-border">
	<tr>
		<th>No.</th>
		<th>Name</th>
		<th>Status</th>
		<th>Start Date</th>
		<th>Start At</th>
		<th>End At</th>
		<th colspan="4">Actions</th>
	</tr>
	<c:if test="${empty todos }">
		<tr>
			<td colspan="6">Empty!</td>
		</tr>
	</c:if>
	<c:if test="${not empty todos }">
		<% int i = 1; %>
		<c:forEach var="m_todo" items="${todos}">
		<tr>
			<td><%=i++ %></td>
			<td>${m_todo.name }</td>
			<td>${m_todo.status }</td>
			<td>${m_todo.startDate }</td>
			<td>${m_todo.startAT }</td>
			<td>${m_todo.endAT }</td>
			<c:if test="${m_todo.status eq 'New'}">
				<td><form action="Controller_M_Todo" method="get"><a href='<spring:url value="/home/update?action=start&idTodo=${m_todo.idTodo }" />'>Start</a></form></td>
				<td><form action="Controller_M_Todo" method="get"><a href='<spring:url value="/home/update?action=edit&idTodo=${m_todo.idTodo }" />'>Edit</a></form></td>
				<td><form action="Controller_M_Todo" method="get"><a href='<spring:url value="/home/update?action=view&idTodo=${m_todo.idTodo }" />'>View</a></form></td>
				<td><form action="Controller_M_Todo" method="get"><a href='<spring:url value="/home/update?action=delete&idTodo=${m_todo.idTodo }" />'>Delete</a></form></td>
			</c:if>
			<c:if test="${m_todo.status eq 'In-Progress'}">
				<td><form action="Controller_M_Todo" method="get"><a href='<spring:url value="/home/update?action=view&idTodo=${m_todo.idTodo }" />'>View</a></form></td>
				<td><form action="Controller_M_Todo" method="get"><a href='<spring:url value="/home/update?action=cancel&idTodo=${m_todo.idTodo }" />'>Cancel</a></form></td>
				<td><form action="Controller_M_Todo" method="get"><a href='<spring:url value="/home/update?action=end&idTodo=${m_todo.idTodo }" />'>End</a></form></td>
			</c:if>
			<c:if test="${m_todo.status eq 'Done'}">
				<td><form action="Controller_M_Todo" method="get"><a href='<spring:url value="/home/update?action=view&idTodo=${m_todo.idTodo }" />'>View</a></form></td>
				<td><form action="Controller_M_Todo" method="get"><a href='<spring:url value="/home/update?action=delete&idTodo=${m_todo.idTodo }" />'>Delete</a></form></td>
			</c:if>
			<c:if test="${m_todo.status eq 'Canceled'}">
				<td><form action="Controller_M_Todo" method="get"><a href='<spring:url value="/home/update?action=view&idTodo=${m_todo.idTodo }" />'>View</a></form></td>
				<td><form action="Controller_M_Todo" method="get"><a href='<spring:url value="/home/update?action=delete&idTodo=${m_todo.idTodo }" />'>Delete</a></form></td>
			</c:if>
		</tr>
		</c:forEach>
	</c:if>
</table>
<div class="action">
	<button type="button" onclick="window.location.href='<spring:url value="/home/create" />'">CREATE</button>
</div>
</body>
</html>