package taskPckg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// JDBC driver name and database URL
	      final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	      final String DB_URL="jdbc:mysql://localhost:3306/db_example";

	      //  Database credentials
	      final String USER = "root";
	      final String PASS = "";

	      // Set response content type
	      response.setContentType("text/html");
	      
	      try 
	      {
	    	 
	         // Register JDBC driver
	         Class.forName(JDBC_DRIVER);
	         
	         // Open a connection    
	    	  
	         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         
	         // Execute SQL query
	         java.sql.Statement stmt = conn.createStatement();
	         /////////
	         
	         String email = request.getParameter("yourEmail");
	         String pass = request.getParameter("yourPass");
	         String passChk = null;
	         
	         String sql = "SELECT * FROM user WHERE email='"+email+ "'";
	         
	         ResultSet rs = stmt.executeQuery(sql);
	         
	         while(rs.next())
	         {
	        	 passChk = rs.getString("password");
	         }

	         if(passChk.equals(pass))
	         {
	        	 //Pass in values
	        	 email = rs.getString("email");
	             String uid = rs.getString("id");
	             	                        			     
	             request.setAttribute("email", email);
   			     request.setAttribute("uid", uid);
   			     
   			     rs.close();
		         stmt.close();
		         conn.close();
       			     
		         //Go to landing
   			     RequestDispatcher rd = request.getRequestDispatcher("landing.jsp");
   			     rd.forward(request, response); 

	         }	 
	         else 
	         {
	        	 response.sendRedirect("invalidLogin.jsp"); //error page 
	         }  
	      } 
	      catch(SQLException se) 
	      {
	         //Handle errors for JDBC
	         se.printStackTrace();
	      } 
	      catch(Exception e) 
	      {
	         //Handle errors for Class.forName
	         e.printStackTrace();
	      }
	}


}
