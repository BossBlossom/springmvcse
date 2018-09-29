<%@page import="model.Danhmucmodel"%>
<%@page import="entities.Product"%>
<%@page import="entities.Item"%>
<%@page import="entities.Danhmuc"%>
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
	<h1>Update San Pham</h1>
<% ArrayList list = new Danhmucmodel().getList(); %>
<form action="UpdateProductServlet?task=update" method="post">
<table border="1">
	<tr>
		<td>MASP</td>
		<td>TENSP</td>
		<td>HINH</td>
		<td>GIA</td>
		<td>MADM</td>
	</tr>
	<tr>
		<td><input type="text" name="txtmasp" value="${param.masp }"></td>
		<td><input type="text" name="txttensp" value="${param.tensp }"></td>
		<td><input type="file" name="file" value="${param.hinh }"></td>
		<td><input type="text" name="txtprice" value="${param.gia }"></td>
		<td>
		<select name="txtmadm" >
					<c:forEach var="dm" items="<%=list%>">
						<option value="${dm.madm}" > ${dm.tendm} </option>
					</c:forEach>
				</select></td>
	</tr>
</table>
<tr>
				<td></td>
				<td><input type="submit" value="Update"></td>
</tr>
</form>
</body>
</html>