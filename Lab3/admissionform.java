

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Servlet implementation class admissionform
 */
@WebServlet("/admissionform")
public class admissionform extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admissionform() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String mobileString = request.getParameter("mobile");
		String city = request.getParameter("city");
		int mobile = Integer.parseInt(mobileString);
		
		String dbhostname = "us-cdbr-iron-east-03.cleardb.net";
		String DBname = "ad_fa2ac1653274060";
		String username ="b1415449c80cfc";
		String password ="3e81b4f9";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			//Modify below mentioned connection url with your credentials
			//Connection con =DriverManager.getConnection("jdbc:mysql://<hostname>/<DBname>?user=<username>&password=<password>");
			Connection con =DriverManager.getConnection("jdbc:mysql://"+dbhostname+"/"+DBname+"?user="+username+"&password="+password);
						
			String insertTableSQL = "INSERT INTO student"
					+ "(FirstName, LastName, Mobile, City) VALUES"
					+ "(?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setString(1,fname);
			preparedStatement.setString(2, lname);
			preparedStatement.setInt(3, mobile);
			preparedStatement.setString(4, city);
			
			// execute insert SQL stetement
			preparedStatement .executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.sendRedirect("/admissionform.html");
		
		
		//response.getWriter().append(request.getContextPath());
		//doGet(request, response);
	}

}
