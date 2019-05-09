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
import data.List_item_data;
import request_handler.Global_functions;

@WebServlet("/Bid_handler")
public class Bid_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Bid_handler() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		HttpSession session = request.getSession();
		
		int item_num = Integer.parseInt(request.getParameter("item_num"));
		float bid_price = Float.parseFloat((String)request.getParameter("bid_price"));
		String email = ((Account_data)session.getAttribute("account_info")).getEmail();
		
		try {
			if(add_bid(conn, item_num, bid_price, email)) {
				session.setAttribute("message", "your bid is a success!");
				email_alert(item_num,conn, session, email);
				List_item_data current_item = (List_item_data) session.getAttribute("current_item");
				update_price_bid(current_item, bid_price);
			}else {
				session.setAttribute("message", "your bid is a failure.");
			}
		} catch (SQLException e) {}
		response.sendRedirect("item_page.jsp");
		return;
	}

	private boolean email_alert(int item_num, Connection conn, HttpSession session, String email) throws SQLException{
		
		String find_person_to_alert = "SELECT a.email FROM alert a INNER JOIN bids b ON a.item_num = b.item_num WHERE a.item_num = ?  ORDER BY b.price DESC LIMIT 1, 1";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(find_person_to_alert);
		ps.setInt(1, item_num);
		rs = ps.executeQuery();
		if(rs.next()) {
			String receiver_email = rs.getString("email");
			String sender_email = email;
			String message = "Careful! item"+item_num+"has been over bid!";
			String send_message = "INSERT INTO email(sender_email, reciver_email, message) VALUES (?,?,?)";
			ps = conn.prepareStatement(send_message);
			ps.setString(1, sender_email);
			ps.setString(2, receiver_email);
			ps.setString(3, message);
			ps.executeUpdate();
			return true;
			}
		return false;
	}
	private boolean add_bid(Connection conn, int item_num, float bid_price, String email) throws SQLException{
		float curr_price = Global_functions.calc_curr_price(item_num, conn);
		if(bid_price > curr_price) {
			PreparedStatement ps = null;
			String query = "INSERT INTO bids(item_num, email, price) value(?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, item_num);
			ps.setString(2, email);
			ps.setFloat(3, bid_price);
			ps.executeUpdate();
			return true;
		}else {
			return false;//failed
		}
	}
	
	private void update_price_bid(List_item_data current_item, float bid_price) {
		current_item.setCurr_price(bid_price);
		int bid_count = current_item.getBid_count() + 1;
		current_item.setBid_count(bid_count);	
	}
	
}





















