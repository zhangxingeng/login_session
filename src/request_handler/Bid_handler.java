package request_handler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.DBConnect;
import data.Account_data;
import data.List_item_data;

/**
 * Servlet implementation class Bid_handler
 */
@WebServlet("/Bid_handler")
public class Bid_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Bid_handler() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		PreparedStatement ps = null;
		
		HttpSession session = request.getSession();
		List_item_data curr_item = (List_item_data)(session.getAttribute("item_info"));
		Account_data curr_user = (Account_data)(session.getAttribute("account_info"));
		
		
		float curr_price = curr_item.getCurr_price();
		float bid_price = Float.parseFloat((String) request.getAttribute("bid_price"));
		if(bid_price > curr_price) {
			Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());	
			String query = "INSERT INTO bid(item_num, email, price, date) value(?, ?, ?, ?)";
			try {
				ps = conn.prepareStatement(query);
				ps.setString(1, curr_item.getItem_num());
				ps.setString(2, curr_user.getEmail());
				ps.setFloat(3, bid_price);
				ps.setTimestamp(4, now);
				ps.executeUpdate();
				curr_item.setCurr_price(bid_price);  //current price is updated when a new bid comes
				email_alert(String Connection conn);
				
			} catch (SQLException e) {}
			//TODO: add help method to send email to all people in watchlist and alert
		}
		
	}

}














