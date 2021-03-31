package taskPckg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
	         java.sql.Statement stmt = conn.createStatement(); 

	         String name = request.getParameter("name");
	         String description = request.getParameter("desc");
	         String severity = request.getParameter("severity");
	         String sd = request.getParameter("sDate");
	         String ed = request.getParameter("eDate");
	         String id = request.getParameter("id");
	         
	         String uid = request.getParameter("uid");
	         
	         String sql = "SELECT * FROM task WHERE id='"+id+ "'";
	         ResultSet rs = stmt.executeQuery(sql);
	         
	         if(rs.getString("user_id").equals(uid))
	         {
	        	 PreparedStatement update;
		         if(!name.isEmpty())
		         {
		        	 update = conn.prepareStatement("UPDATE userdetails SET name='"+name+ "' WHERE id = '"+id+"'");
		        	 update.executeUpdate();
		         }
		         if(!description.isEmpty())
		         {
		        	 update = conn.prepareStatement("UPDATE userdetails SET username='"+description+ "' WHERE id = '"+id+"'");
		        	 update.executeUpdate();
		         }
		         if(!severity.isEmpty())
		         {
		        	 update = conn.prepareStatement("UPDATE userdetails SET password='"+severity+ "' WHERE id = '"+id+"'");
		        	 update.executeUpdate();
		         }
		         if(!sd.isEmpty())
		         {
		        	 update = conn.prepareStatement("UPDATE userdetails SET password='"+sd+ "' WHERE id = '"+id+"'");
		        	 update.executeUpdate();
		         }  
		         if(!ed.isEmpty())
		         {
		        	 update = conn.prepareStatement("UPDATE userdetails SET password='"+ed+ "' WHERE id = '"+id+"'");
		        	 update.executeUpdate();
		         }
		         
			     
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
