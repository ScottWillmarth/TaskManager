<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Landing Page</title>
</head>
<body>
	<% 
		String email = request.getParameter("email"); 
		session.setAttribute("email",email); 
		String uid = request.getParameter("uid"); 
		session.setAttribute("uid",uid); 
	%> 

<br>
<button onclick="window.location.href='display.jsp'">Show my tasks</button>
<button onclick="window.location.href='add.jsp'">Add a task</button>
<button onclick="window.location.href='updateTask.jsp'">Update a task</button>
<button onclick="window.location.href='deleteTask.jsp'">Delete a task</button>
<button onclick="window.location.href='index.jsp'">Log out</button>
</body>
</html>