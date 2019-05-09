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
import data.List_item_data;


@WebServlet("/Set_alert_handler")
public class Set_alert_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static Date addDay(Date date) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.DAY_OF_YEAR, 7);
	        return cal.getTime();
	    }
	
    public Set_alert_handler() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		String redirect = "item_page.jsp";
		int item_num = (int)((List_item_data)session.getAttribute("current_item")).getItem_num();
		if(session.getAttribute("account_info") == null) {
			request.setAttribute("message", "please log in first.");
			response.sendRedirect("index.jsp");
			return;
		}
		String email = ((Account_data)session.getAttribute("account_info")).getEmail();
		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		PreparedStatement ps = null;
		try {
			String query = 	"INSERT IGNORE INTO alert(email, item_num) VALUES (?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(1,email);
			ps.setInt(2,item_num);
			ps.executeUpdate();
			request.setAttribute("message", "Your alert is successfully set.");
			
		}catch (SQLException e) {
			session.setAttribute("message", "Problem occured at Set_alert_handler.java!");
		}		
		finally {
			try {
				if(conn != null) {
					conn.close();
					response.sendRedirect(redirect);
				}
			} catch (SQLException e) {}
		}
	}
	
}