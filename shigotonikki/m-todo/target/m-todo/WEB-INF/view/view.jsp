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
<body style="margin:auto;">
<a onclick="window.location.href='<spring:url value="/home" />'"><h3 class="blue">M-TODO</h3></a>
<h1><center>VIEW M-TODO</center></h1>
<form:form modelAttribute="m_todo">
	<div class="input-group">
		<label>Name</label>
		<form:input path="name" readonly="true"/>
	</div>
	<div class="input-group">
		<label>Status</label>
		<form:input path="status" readonly="true" />
	</div>	
	<div class="input-group">
		<label>Start Date</label>
		<form:input path="startDate" readonly="true" />
	</div>
	<div class="input-group">
		<label>Start At</label>
		<form:input path="startAT" readonly="true" />
	</div>
	<div class="input-group">
		<label>Created At</label>
		<form:input path="endAT" readonly="true" />
	</div>
	<div class="input-group">
		<label>Description</label>
		<form:input path="description" readonly="true" />
	</div>
</form:form>
<table>
	<th><form action="Controller_M_Todo" method="get"><a href='<spring:url value="/home/update?action=edit&idTodo=${m_todo.idTodo }" />'><button type="button">Edit</button></a></form></th>
	<th><form action="Controller_M_Todo" method="get"><a href='<spring:url value="/home/update?action=delete&idTodo=${m_todo.idTodo }" />'><button type="button">Delete</button></a></form></th>
</table>
</body>
</html>