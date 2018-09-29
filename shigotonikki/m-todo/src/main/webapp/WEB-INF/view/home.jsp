<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/app.css"/>">
<body style="margin:auto;">
<a onclick="window.location.href='<spring:url value="/home" />'"><h3 class="blue">M-TODO</h3></a>
<table id="example" class="tbl-border">
<thead>
	<tr>
		<th>No.</th>
		<th>Name</th>
		<th>Status</th>
		<th>Start Date</th>
		<th>Start At</th>
		<th>End At</th>
		<th colspan="4">Actions</th>
	</tr>
</thead>
	<c:if test="${empty todos }">
		<tr>
			<td colspan="6">Empty!</td>
		</tr>
	</c:if>
	<c:if test="${not empty todos }">
	<tbody>
		<% int i = 1; %>
		<% int x = 1; %>
		<c:forEach var="m_todo" items="${todos}">
		<tr class="${m_todo.status }">
			<td><%=i++ %></td>
			<td>${m_todo.name }</td>
			<td>${m_todo.status }<c:if test="${m_todo.status eq 'New'}"> <%=x++ %></c:if></td>
			<td>${m_todo.startDate }</td>
			<td>${m_todo.startAT }</td>
			<td>${m_todo.endAT }</td>
			<c:if test="${m_todo.status eq 'New'}">
				<td><a href='<spring:url value="/home/start?idTodo=${m_todo.idTodo }" />'>Start</a></td>
				<td><a href='<spring:url value="/home/update?idTodo=${m_todo.idTodo }" />'>Edit</a></td>
				<td><a href='<spring:url value="/home/view?idTodo=${m_todo.idTodo }" />'>View</a></td>
				<td><a href='<spring:url value="/home/delete?idTodo=${m_todo.idTodo }" />'>Delete</a></td>
			</c:if>
			<c:if test="${m_todo.status eq 'In-Progress'}">
				<td><a href='<spring:url value="/home/view?idTodo=${m_todo.idTodo }" />'>View</a></td>
				<td><a href='<spring:url value="/home/cancel?idTodo=${m_todo.idTodo }" />'>Cancel</a></td>
				<td><a href='<spring:url value="/home/end?idTodo=${m_todo.idTodo }" />'>End</a></td>
				<td></td>
			</c:if>
			<c:if test="${m_todo.status eq 'Done'}">
				<td><a href='<spring:url value="/home/view?idTodo=${m_todo.idTodo }" />'>View</a></td>
				<td><a href='<spring:url value="/home/delete?idTodo=${m_todo.idTodo }" />'>Delete</a></td>
				<td></td>
				<td></td>
			</c:if>
			<c:if test="${m_todo.status eq 'Canceled'}">
				<td><a href='<spring:url value="/home/view?idTodo=${m_todo.idTodo }" />'>View</a></td>
				<td><a href='<spring:url value="/home/delete?idTodo=${m_todo.idTodo }" />'>Delete</a></td>
				<td></td>
				<td></td>
			</c:if>
		</tr>
		</c:forEach>
	</tbody>
	</c:if>
</table>
<div class="action">
	<button type="button" onclick="window.location.href='<spring:url value="/home/create" />'">CREATE</button>
</div>
</body>
</html>