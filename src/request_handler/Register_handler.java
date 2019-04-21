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
        // TODO Auto-generated connstructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String input_email=(String)request.getParameter("email");
		String input_password=(String)request.getParameter("password");
		String input_username=(String)request.getParameter("username");
		String input_address=(String)request.getParameter("address");
		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		PreparedStatement prepst = null;
		ResultSet rs = null;
		

		try {
			String selectSQL = "SELECT email FROM user WHERE email=?";
			prepst = conn.prepareStatement(selectSQL);
			prepst.setString(1,input_email);

			// execute select SQL stetement
		   rs = prepst.executeQuery();

			if (!rs.next()) {
				String insertSQL = "INSERT INTO user(email, password,username,address) VALUES (?, ?, ?, ?)";
				prepst = conn.prepareStatement(insertSQL);
				prepst.setString(1,input_email);
				prepst.setString(2,input_password);
				prepst.setString(3,input_username);
				prepst.setString(4,input_address);
                int i= prepst.executeUpdate();
                if(i != 0 ) {
                	System.out.println("successed!");//success
                	response.sendRedirect("index.jsp");//redirect index
                }else {
                	System.out.println("error occurred");//error occurred
                	response.sendRedirect("register.jsp");//redirict register
                }
			}else {
				System.out.println("this email alreay exists!");//this email alreay exists
				response.sendRedirect("register.jsp");//redirct register
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		
	finally {

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
		
		
		
		
	
		