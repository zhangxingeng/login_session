package request_handler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
        // TODO Auto-generated connstructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		HttpSession session = request.getSession();
        String action = (String)request.getParameter("action");
        String input_email=(String)request.getParameter("email");
        String input_password=(String)request.getParameter("password");
        
		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		PreparedStatement ps = null;
		
		
		try {
			if(action.equals("add")) {
				
				String insertSQL = "INSERT INTO user(email, password) VALUES (?, ?)";
				ps = conn.prepareStatement(insertSQL);
				ps.setString(1,input_email);
				ps.setString(2,input_password);
				System.out.println(ps.toString());
				ps.executeUpdate();
				
				
			}else {
				String DeleteSQL = "DELETE FROM user WHERE email = ?";
				ps = conn.prepareStatement(DeleteSQL);
				ps.setString(1,input_email);
				ps.executeUpdate();
			}
		}
		catch (Exception e){
			session.setAttribute("failure_message", "Problem occurred at 1 AdminCRM_handler.java!");
		}
		finally {
			try {
				
				if(conn != null) {conn.close();}
			} catch (SQLException e) {}
			
		}
		response.sendRedirect("admin_home.jsp");
	}
}

