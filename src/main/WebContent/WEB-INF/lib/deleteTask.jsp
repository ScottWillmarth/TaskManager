<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
        
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete a Task</title>
</head>
<body>
    <form action="deleteServlet" method="post">
    Enter the ID of the Task: <input type="text" name="id" id="id" required>
    <input type="hidden" name="uid" id="uid" value= <%= request.getAttribute("uid") %>>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>