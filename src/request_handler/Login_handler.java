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
import data.User_data;

/**
 * Servlet implementation class Login_handler
 */
@WebServlet("/Login_handler")
public class Login_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user_info") != null) {
			response.sendRedirect("login_control/index.jsp");
		}
		
		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM users WHERE email=? AND password=?";

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, request.getParameter("email"));
			ps.setString(2, request.getParameter("password"));
			rs = ps.executeQuery();
			
			if(rs.next()) {
				User_data userinfo = new User_data (rs.getString("email"), rs.getString("password"), 
						rs.getString("name"), rs.getString("address"), rs.getString("state"), 
						rs.getString("zip"), rs.getString("phone_num"));
				session.setAttribute("user_info", userinfo);
			}
			response.sendRedirect("login_control/index.jsp");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
