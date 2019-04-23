package request_handler;

import java.util.*;
import java.util.Date;
import java.io.IOException;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import connect.DBConnect;
import data.Account_data;


@WebServlet("/Add_to_watchlist_handler")
public class Add_to_watchlist_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static Date addDay(Date date) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.DAY_OF_YEAR, 6);
	        return cal.getTime();
	    }
	
    public Add_to_watchlist_handler() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		int item_num = (int)request.getAttribute("add_to_watchlist");
		
		//get email from session
		HttpSession session = request.getSession();
		String email=(String)request.getParameter("email");
		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//INSERT INTO alert () VALUE(?,?)
			String query = 	"INSERT INTO watchlist(email, item_num) VALUES (?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(1,email);
			ps.setInt(2,item_num);
			ps.executeQuery();
			
			response.sendRedirect("item_page.jsp");
		}catch (SQLException e) {
			session.setAttribute("failure_message", "Problem occured at Add_to_watchlist_handler.java!");
		}		
		finally {try {if(conn != null) {conn.close();}
				} catch (SQLException e) {}
		}
	
	
		
		
		//create schedule task(query item start date +6 days)
		 Date now = new Date(System.currentTimeMillis());
		 TimerTask task = new TimerTask() {
	           @Override
	           public void run() { 
	        	   
	        	   alert_watchlist(conn, item_num);
	         
	           }
	       };
	       Timer timer = new Timer();		     
		   timer.schedule(task, addDay(now));
		
}
	
	
	public static void alert_watchlist(Connection conn, int item_num) {
		
	}
	/*
	 * send message to watchlister item about to be sold!
	 */
	
}