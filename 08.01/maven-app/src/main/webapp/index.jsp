<%@page import="model.ProductModel"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.ACONST_NULL"%>
<%@page import="entities.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ProductModel" %>
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
	View page
	<table border="1">
		<tr>
			<th>MADM</th>
			<th>MASP</th>
			<th>TENSP</th>
			<th>GIA</th>
			<th>HINH</th>
			<th>Action</th>
			<th>Action</th>
		</tr>
	<% ProductModel promodel = new ProductModel(); %>
	<c:forEach var="p" items="<%= promodel.getList() %>">
	<tr>
		<td>${p.madm}</td>
		<td>${p.masp}</td>
		<td>${p.tensp}</td>
		<td>${p.gia}</td>
		<td><img src="Images/${p.hinh}" height="150px" width="120px"/></td>
		<td><a href="CartServlet?action=add&masp=${p.masp}">Add Cart</a></td>
		<c:url var="update" value="UpdateProduct.jsp">
			<c:param name="madm" value="${p.madm}"/>
			<c:param name="masp" value="${p.masp}"/>
			<c:param name="tensp" value="${p.tensp}"/>
			<c:param name="gia" value="${p.gia}"/>			
			<div><img name="hinh" src="Images/${p.hinh}"></div>
		</c:url>
		<td><a href="${update}">Update</a>
	</tr>
	</c:forEach>
	</table>
	<p><a href="uploadimage.jsp">Insert</a></p>
</body>
</html>