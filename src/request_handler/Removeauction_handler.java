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

@WebServlet("/Removeauction_handler")
public class Removeauction_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Removeauction_handler() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        HttpSession session = request.getSession();
        String itemnumber =request.getParameter("item_num");
        int item_num= Integer.parseInt(itemnumber);
		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		PreparedStatement prepst = null;
		
		try {
			String deleteAuction = "DELETE FROM item where item_num =?";
			prepst = conn.prepareStatement(deleteAuction);
			prepst.setInt(1,item_num);

			// execute select SQL statement
		  int i = prepst.executeUpdate();
		
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
