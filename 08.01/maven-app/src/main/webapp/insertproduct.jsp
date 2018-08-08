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
	<h1>Insert Product</h1>
	<form action="ProductServlet?task=insert" method="Post">
		<table>
			<tr>
				<td>ID
				<td><input type="text" name="txtid">
			</tr>
			<tr>
				<td>Name
				<td><input type="text" name="txtname">
			</tr>
			<tr>
				<td>Price
				<td><input type="text" name="txtprice">
			</tr>
			<tr>
				<td>Image
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<% ArrayList list = new Danhmucmodel().getList(); %>
				<td>Danh Muc
				<select name="madm" >
					<c:forEach var="dm" items="<%=list%>">
						<option value="${dm.madm}" > ${dm.tendm} </option>
					</c:forEach>
				</select>
			</tr>
			</form>
			<tr>
				<td></td>
				<td><input type="submit" value="Insert"></td>
			</tr>
		</table>
	</form>
</body>
</html>