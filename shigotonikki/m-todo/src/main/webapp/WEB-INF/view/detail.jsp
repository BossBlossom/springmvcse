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
<h1><center>M-Todo Detail</center></h1>
<form:form modelAttribute="m_todo">
	<div class="input-group">
		<label>Name</label>
		<form:input path="name"/>
	</div>
	<div class="input-group">
		<label>Description</label>
		<form:input path="description"/>
	</div>
	<div class="input-group">
		<label>Start Date</label>
		<form:input path="startDate" type="date"/>
	</div>
	<form:button name="action" value="save">セーブ</form:button>
	<button type="button" onclick="window.location.href='<spring:url value="/home" />'">キャンセル</button>
</form:form>
</body>
</html>