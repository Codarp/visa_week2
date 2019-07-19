<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products using JSTL</title>
</head>
<body>
	Welcome, ${ user } <br /> <!-- Looks in session object -->
	<a href="LoginServlet">Sign Out</a>
	<h2>Product List using JSTL</h2>
	<table border="1">
		<tr>
			<th>ID</th><th>Name</th><th>Price</th>
		</tr>
		<c:forEach items="${cart}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.price}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="products">Back to Product List</a>
</body>
</html>