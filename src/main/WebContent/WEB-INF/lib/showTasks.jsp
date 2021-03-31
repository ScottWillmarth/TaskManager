<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tasks</title>
<%@page import="java.sql.*;"%>
</head>
<body>
<%
    try
    {
    	String uid = request.getParameter("uid"); 
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=(Connection)DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/db_example","root","");
        Statement st =con.createStatement();
        ResultSet rs =st.executeQuery("select * from task WHERE user_id = '"+uid+"'");
 %>
    <table border=1 style="text-align:center">
      <thead>
          <tr>
             <th>ID</th>
             <th>Name</th>
             <th>Description</th>
             <th>Severity</th>
             <th>Start Date</th>
             <th>End Date</th>
             <th>Email</th>
             <th>User ID</th>
          </tr>
      </thead>
      <tbody>
        <%while(rs.next())
        {
            %>
            <tr>
                <td><%=rs.getString("id") %></td>
                <td><%=rs.getString("name") %></td>
                <td><%=rs.getString("description") %></td>
                <td><%=rs.getString("severity") %></td>
                <td><%=rs.getDate("start_date") %></td>
                <td><%=rs.getDate("end_date") %></td>
                <td><%=rs.getString("email") %></td>
                <td><%=rs.getString("user_id") %></td>
            </tr>
            <%}%>
           </tbody>
        </table><br>
    <%
    }
    catch(Exception e){
        out.print(e.getMessage());%><br>
        <%
    }
    %>

</body>
</html>