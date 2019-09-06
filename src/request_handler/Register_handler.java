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


@WebServlet("/Register_handler")
public class Register_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Register_handler() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String input_email=(String)request.getParameter("email");
		String input_password=(String)request.getParameter("password");
		
		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String redirect_url = "register.jsp";
		
		try {
			String query_exist_check = "SELECT * FROM user WHERE email=?";
			ps = conn.prepareStatement(query_exist_check);
			ps.setString(1,input_email);

			// execute select SQL statement
		   rs = ps.executeQuery();

			if (!rs.next()) {
				String query_insert = "INSERT IGNORE INTO user(email, password) VALUES (?, ?)";
				ps = conn.prepareStatement(query_insert);
				ps.setString(1,input_email);
				ps.setString(2,input_password);
                ps.executeUpdate();
                redirect_url = "index.jsp";
               
                session.setAttribute("message", "You are registered.");
			}
		} catch (SQLException e) {
			session.setAttribute("message", "Error: Register_handler.java.");
		}
		
		finally {
			try {if(conn != null) {
				conn.close();
				System.out.println(redirect_url);
				response.sendRedirect(redirect_url);
				}
			} catch (SQLException e) {}
		}
	}
}
		
		
		
		
	
		