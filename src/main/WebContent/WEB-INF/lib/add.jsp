<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
        
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a new Task</title>
</head>
<body>
    <form action="addServlet" method="post">
    Name: <input type="text" name="newName" id="newName" required> <br><br>
    Description: <input type="text" name="newDesc" id="newDesc" required> <br><br>
    Severity: <input type="text" name="severity" id="severity" required> <br><br>
    Start Date: <input type="date" name="sDate" id="sDate" required> <br><br>
    End Date: <input type="date" name="eDate" id="eDate" required> <br><br>
    <input type="hidden" name="email" id="email" value= <%= request.getAttribute("email") %>>
    <input type="hidden" name="id" id="id" value= <%= request.getAttribute("uid") %>>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>