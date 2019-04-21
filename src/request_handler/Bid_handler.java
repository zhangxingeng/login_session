package request_handler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

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
				ps.setInt(1, curr_item.getItem_num());
				ps.setString(2, curr_user.getEmail());
				ps.setFloat(3, bid_price);
				ps.setTimestamp(4, now);
				ps.executeUpdate();
				curr_item.setCurr_price(bid_price);  //current price is updated when a new bid comes
				email_alert(curr_item.getItem_num(),conn, session);

			} catch (SQLException e) {
				session.setAttribute("failure_message", "Problem occur at 1 Bid_handler.java!");
				
			}
			finally {
					try {
						if(conn != null) {conn.close();}} 
					catch (SQLException e) {}}}}

	private void email_alert(int item_num, Connection conn, HttpSession session) {
		
		String find_person_to_alert = "("
				+ "SELECT * "
				+ "FROM alert a "
				+ "WHERE a.item_num = ? "
				+ "ORDER BY date DESC) "
				+ "INNER JOIN ("
					+ "SELECT TOP 1 * "
					+ "FROM bid b "
					+ "WHERE b.item_num = ? "
					+ "ORDER BY b.price DESC"
				+ ") "
				+ "ON (a.item_num = b.item_num)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(find_person_to_alert);
			ps.setInt(1, item_num);
			ps.setInt(2, item_num);
			rs = ps.executeQuery();
			
			String receiver_email = rs.getString("email");
			String sender_email = ((Account_data)session.getAttribute("account_info")).getEmail();
			String message = "Careful! item"+item_num+"has been over bid!";
			String send_message = "INSERT INTO email(sender_email, receiver_email, message) VALUES (?,?,?)";
			ps = conn.prepareStatement(send_message);
			ps.setString(1, sender_email);
			ps.setString(2, receiver_email);
			ps.setString(3, message);
			ps.executeUpdate();
		} catch (SQLException e) {
			session.setAttribute("failure_message", "Problem occur at 2 Bid_handler.java!");}

                   finally {try {
                            if(conn != null) {conn.close();}
                       } catch (SQLException e) {}}}}


