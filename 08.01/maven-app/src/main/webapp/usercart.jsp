<%@ page import="entities.Item" %>
<%@ page import="java.util.ArrayList" %>
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
	<h1>View Cart!</h1>
<% ArrayList<Item> cart =(ArrayList<Item>)request.getAttribute("list"); %>
<form action="CartServlet" method="post">
<table border="1">
	<tr>
		<td>MASP</td>
		<td>TENSP</td>
		<td>HINH</td>
		<td>GIA</td>
		<td>SOLUONG</td>
		<td>TOTAL</td>
		<td>Action</td>
	</tr>
<c:forEach var="i" items="<%=cart%>">
	<tr>
		<td>${i.sanpham.masp}</td>
		<td>${i.sanpham.tensp}</td>
		<td><img src="Images/${i.sanpham.hinh}" height="90px" width="60px"/></td>
		<td>${i.sanpham.gia}</td>
		<td>${i.soluong}</td>
		<td>${i.sanpham.gia*i.soluong}</td>
		<td>
		<a href="CartServlet?action=delete&masp=${i.sanpham.masp}">Delete</a>
		</td>
</c:forEach>
</table>
<p><b>Total :<%= request.getAttribute("totalcart") %></b></p>
<a href="index.jsp">Tiep tuc mua</a>
<a href="CartServlet?action=removeall">Xoa cart</a>
<input type="submit" value="Buy">
</form>
</body>
</html>