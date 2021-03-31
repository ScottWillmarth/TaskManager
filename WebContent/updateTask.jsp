<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
        
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update a Task</title>
</head>
<body>
    <form action="updateServlet" method="post">
    Change name: <input type="text" name="name" id="name"> <br><br>
    Change description: <input type="text" name="newDesc" id="desc"> <br><br>
    ChangeSeverity: <input type="text" name="severity" id="severity"> <br><br>
    Change Start Date: <input type="date" name="sDate" id="sDate"> <br><br>
    Change End Date: <input type="date" name="eDate" id="eDate"> <br><br>
    <input type="hidden" name="id" id="id" value= <%= request.getAttribute("uid") %>>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>