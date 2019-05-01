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


@WebServlet("/Add_to_watchlist_handler")
public class Add_to_watchlist_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBConnect DBC = new DBConnect();
	Connection conn = DBC.getConn();
	
    public Add_to_watchlist_handler() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		int item_num = (int)request.getAttribute("add_to_watchlist");
		
		//get email from session
		HttpSession session = request.getSession();
		String email=(String)request.getParameter("email");
		
		PreparedStatement ps = null;
		try {
			//INSERT INTO alert () VALUE(?,?)
			String query = 	"INSERT INTO watchlist(email, item_num) VALUES (?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(1,email);
			ps.setInt(2,item_num);
			ps.executeUpdate();
			
			//create schedule task(query item start date +6 days)
			 Date now = new Date(System.currentTimeMillis());
			 TimerTask task = new TimerTask() {
		           @Override
		           public void run() { 
		        	   alert_watchlist(conn, item_num);
		           }
		       };
		       Timer timer = new Timer();		     
			   timer.schedule(task, addDay(now, 6));
			   
			response.sendRedirect("item_page.jsp");
		}catch (SQLException e) {
			session.setAttribute("failure_message", "Problem occured at Add_to_watchlist_handler.java!");
		}		
		finally {try {if(conn != null) {conn.close();}
				} catch (SQLException e) {}
		}	
}
	
	public static void alert_watchlist(Connection conn, int item_num) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			String query_find_all_watchlisters = "SELECT w.email FROM watchlist w WHERE w.item_num = ?";
			ps = conn.prepareStatement(query_find_all_watchlisters);
			ps.setInt(1, item_num);
			rs= ps.executeQuery();
			while(rs.next()) {
				String email = rs.getString("email");
				String query_add_email = "INSERT INTO email (receiver_email, sender_email, message) value(?,?,?)";
				ps = conn.prepareStatement(query_add_email);
				ps.setString(1, email);
				ps.setString(2, "System@buyme.com");
				ps.setString(3, "Your item"+item_num+"is 24 hours left to be sold!");
				ps.executeUpdate();
			}
		} catch (SQLException e) {}
	}
	/*
	 * send message to watchlister item about to be sold!
	 */
	public static Date addDay(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, day);
        return cal.getTime();
    }
}