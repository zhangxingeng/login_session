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
		
		try {
			String query = "SELECT * FROM ? WHERE email=? AND password=?";
			ps = conn.prepareStatement(query);
			String accountinfo = null;
			
			if( ((String)request.getParameter("identity")).equals("staff") ) {
				ps.setString(1, request.getParameter("cus_rep"));
				accountinfo = "staff";
			}else if( ((String)request.getParameter("identity")).equals("admin") ) {
				ps.setString(1, request.getParameter("admin"));
				accountinfo = "admin";
			}else { //user
				ps.setString(1, request.getParameter("user"));
				accountinfo = "user";	
			}
			
			ps.setString(2, request.getParameter("email"));
			ps.setString(3, request.getParameter("password"));
			rs = ps.executeQuery();
			
			
			if(rs.next()) {	
				String email = rs.getString("email");
				String password = rs.getString("password");
				if(accountinfo.equals("staff")){
					Account_data stf = new Account_data(email,password,"staff");
					session.setAttribute("account_info", stf);
					response.sendRedirect("login_control/staff_home.jsp");
				}else if(accountinfo.equals("admin")){
					Account_data adm = new Account_data(email,password,"admin");
					session.setAttribute("account_info", adm);
					response.sendRedirect("login_control/admin_home.jsp");
				}else{
					Account_data usr = new Account_data(email, password,rs.getString("name"), 
						rs.getString("address"), rs.getString("state"), 
						rs.getString("zip"), rs.getString("phone_num"));
					session.setAttribute("account_info", usr);
				}
				
			}
		} catch (SQLException e1) {
			session.setAttribute("failure_message", "Problem occured at Login_handler.java!");}
		
		finally {
			try {
				if(conn != null) {conn.close();}
			} catch (SQLException e) {}}
		response.sendRedirect("login_control/index.jsp");
		}
	}




