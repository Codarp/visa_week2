<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Game Ends</title>
</head>
<body>
	<h1>Game has ended</h1>
	You <%= session.getAttribute("result") %>
	<a href="newGame.html">Back to Starting.</a>
</body>
</html>