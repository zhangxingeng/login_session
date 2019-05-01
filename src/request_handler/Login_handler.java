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

import data.Account_data;


@WebServlet("/Login_handler")
public class Login_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Login_handler() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user_info") != null) {
			response.sendRedirect("index.jsp");
		}
		
		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String login_query = "";
		String accountinfo = (String)request.getParameter("identity");
		String redirect_url = "index.jsp";
		
		if(accountinfo.equals("staff")) {
			login_query = "SELECT * FROM staff WHERE staff_email=? AND password=?";	
		}else if(accountinfo.equals("admin")) {
			login_query = "SELECT * FROM admin WHERE admin_email=? AND password=?";
		}else { //user
			login_query = "SELECT * FROM user WHERE email=? AND password=?";
		}	
		try {
			ps = conn.prepareStatement(login_query);
			ps.setString(1, request.getParameter("email"));
			ps.setString(2, request.getParameter("password"));
			rs = ps.executeQuery();
			
			
			if(rs.next()) {	
				Account_data account = null;
				if(accountinfo.equals("staff")){
					account = new Account_data(rs.getString("staff_email"),rs.getString("password"),"staff");
					redirect_url = "staff_home.jsp";
				}else if(accountinfo.equals("admin")){
					account = new Account_data(rs.getString("admin_email"), rs.getString("password"), "admin");
					redirect_url = "admin_home.jsp";
				}else{
					account = new Account_data(rs.getString("email"), rs.getString("password"),rs.getString("name"), 
							rs.getString("address"), rs.getString("state"), rs.getString("zip"), rs.getString("phone_num"));
					redirect_url = "index.jsp";
				}
				session.setAttribute("account_info", account);
				
			}
		} catch (SQLException e1) {
			session.setAttribute("failure_message", "Problem occured at Login_handler.java!");}
		
		finally {
			try {
				if(conn != null) {conn.close();}
			} catch (SQLException e) {}
			}
		response.sendRedirect(redirect_url);
		}
	}




