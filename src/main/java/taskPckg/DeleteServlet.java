package taskPckg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
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
	         Statement st = conn.createStatement();
	         java.sql.Statement stmt = conn.createStatement(); 

	         String id = request.getParameter("id");
	         String uid = request.getParameter("uid");
	         
	         String sql = "SELECT * FROM task WHERE id='"+id+ "'";
	         ResultSet rs = stmt.executeQuery(sql);
	         
	         if(rs.getString("user_id").equals(uid))
	         {
	        	 st.executeUpdate("delete from task WHERE id = '"+id+"'");

			     response.sendRedirect("landing.jsp");
	         }
	         else
	         {
	        	 response.sendRedirect("error.jsp");
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
