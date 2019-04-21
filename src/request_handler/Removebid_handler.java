package request_handler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.DBConnect;

@WebServlet("/Removebid_handler")
public class Removebid_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Removebid_handler() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    HttpSession session = request.getSession();
			DBConnect DBC = new DBConnect();
			Connection conn = DBC.getConn();
			
			
			try {
				
				String deleteBid = "DELETE FROM bids ORDER BY date DESC LIMIT 1";
				Statement delbid = conn.createStatement();
				int i =delbid.executeUpdate(deleteBid);

				// execute select SQL statement
			   
			if(i != 0 ) {
	          	System.out.println("successed!");//success
	          	response.sendRedirect("staff_home.jsp");//redirect index
	          }else {
	          	System.out.println("error occurred");//error occurred
	          	response.sendRedirect("staff_home.jsp");//redirect register
	          }
			  
			  
			}catch(SQLException e) {}finally {

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


