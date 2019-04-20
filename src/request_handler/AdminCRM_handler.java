package request_handler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.DBConnect;

/**
 * Servlet implementation class AdminCRM_handler
 */
@WebServlet("/AdminCRM_handler")
public class AdminCRM_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCRM_handler() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		HttpSession session = request.getSession();
        
        String input_email=(String)request.getParameter("email");
        String input_password=(String)request.getParameter("password");
        
		DBConnect DB = new DBConnect();
		Connection con = DB.getConn();
		PreparedStatement prepst = null;
		
		
		try {
			 String insertSQL = "INSERT INTO user(email, password) VALUES (?, ?)";
			 prepst = con.prepareStatement(insertSQL);
				prepst.setString(1,input_email);
				prepst.setString(2,input_password);
				prepst.executeUpdate();
			
			String DeleteSQL = "delete from user WHERE email = ?";
			prepst = con.prepareStatement(DeleteSQL);
			prepst.setString(1,input_email);
			prepst.executeUpdate();
			
		}
		catch (Exception e){
			
			e.printStackTrace();
			
		}
		finally {

			try {
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	
	
	}
}
