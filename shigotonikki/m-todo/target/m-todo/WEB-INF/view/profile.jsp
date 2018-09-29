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
<h1><center>M-Todo Profile</center></h1>
<form:form modelAttribute="profile" action="profile/update" method="post" enctype="multipart/form-data">
	<div class="input-group">
		<label>Avatar</label>
		<input type="file" name="file"/>
	</div>
	<div class="input-group">
		<label>Email</label>
		<form:input path="email"/>
	</div>
	<div class="input-group">
		<label>Full Name</label>
		<form:input path="fullName"/>
	</div>
	<div class="input-group">
			<label>Gender</label>
			<form:select path="gender" >
				<form:option value="Male">Male</form:option>
				<form:option value="Female">FeMale</form:option>
				<form:option value="Other">Other</form:option>
			</form:select>
	</div>
	<div class="input-group">
		<label>Birth Date</label>
		<form:input path="birthDate" type="date"/>
	</div>
	<div class="input-group">
		<label>Address</label>
		<form:input path="address"/>
	</div>
	<div class="input-group">
		<label>Phone</label>
		<form:input path="phone"/>
	</div>
	<form:button name="action" value="save">セーブ</form:button>
	<button type="button" onclick="window.location.href='<spring:url value="/home" />'">キャンセル</button>
</form:form>
</body>
</html>