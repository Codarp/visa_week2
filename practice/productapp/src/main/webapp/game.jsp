<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guessing Game</title>
</head>
<body>
	<h1>Guessing Game</h1>
	Question:<br />
	Which data structure should be used if adding/removing is from arbitrary position and
	need indexed operation? <br />
	
	Life left: ${life} <br />
	Answer: ${ word } <br />
	<form method="post" action="GameServlet">
		Character : <input type="text" name="char" maxlength=1 required/><br />
		<button type="submit">submit</button>
	</form>
</body>
</html>