<%@page import="model.Danhmucmodel"%>
<%@page import="entities.Danhmuc"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.ACONST_NULL"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form enctype="multipart/form-data" action="ProductServlet?action=upload" method="Post">
		<% ArrayList list = new Danhmucmodel().getList(); %>
		<select name="madm" >
			<c:forEach var="dm" items="<%=list%>">
				<option value="${dm.madm}" > ${dm.tendm} </option>
			</c:forEach>
		</select>
		<input type="file" name="file">
		<input type="submit">
	</form>
</body>
</html>