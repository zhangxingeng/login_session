package request_handler;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


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
	        String item_number =request.getParameter("item_num");
	        int item_num= Integer.parseInt(item_number);
	        
	        String Email =request.getParameter("email");
	        
	        String Date = request.getParameter("date");
	        
	       
			
			DBConnect DB = new DBConnect();
			Connection con = DB.getConn();
			PreparedStatement prepst = null;
			
			try {
				String deleteBid = "DELETE FROM (SELETE item_num,email, max(data) from (SELETE * FROM item i, bids b where i.item_num = b.item_num, i.email= b.email) AS T) AS T1 WHERE item_num=?,email=?,max(date)=?";
				prepst = con.prepareStatement(deleteBid);
				prepst.setInt(1,item_num);
				prepst.setString(2,Email);
				prepst.setString(3, Date);

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
					if(con != null) {
						con.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}
	

		
		
		
	}


