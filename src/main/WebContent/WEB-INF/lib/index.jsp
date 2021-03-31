<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log-in Page</title>
</head>
<body>
    <form action="loginServlet" method="POST">
    Email: <input type="text" name="yourEmail" id="yourEmail" required> <br><br>
    Password: <input type="text" name="yourPass" id="yourPass" required> <br><br>
    <input type="submit" value="Log in"/>
	</form>
	
	<button onclick="window.location.href='register.jsp'">Register</button>
</body>
</html>