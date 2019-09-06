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

/**
 * Servlet implementation class bid_handler2
 */
@WebServlet("/bid_handler2")
public class Bid_handler2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bid_handler2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		PreparedStatement ps = null;
		
		HttpSession session = request.getSession();
		int item_num = Integer.parseInt(request.getParameter("item_num"));
		Account_data curr_user = (Account_data)(session.getAttribute("account_info"));
		String query = "SELECT TOP 1 price FROM bid WHERE item_num = ?";
		try {
			ps = conn.prepareStatement(query);
		
			ps.setInt(1, item_num);
			ResultSet rs = ps.executeQuery();
			float curr_price = -1;
			if(rs.next()) {
				 curr_price = rs.getFloat("price");
			}
			String query2 = "SELECT start_price FROM item WHERE item_num = ?";
			ps = conn.prepareStatement(query2);
			ps.setInt(1, item_num);
			ResultSet rs2 = ps.executeQuery();
			float start_price = -1;
			if(rs2.next()) {
				start_price = rs2.getFloat("start_price");
			}
			if(start_price > curr_price) {
				curr_price = start_price;
			}
		
			System.out.println("curr_price: "+curr_price);
			float bid_price = Float.parseFloat((String) request.getParameter("bid_price"));
			System.out.println("bid_price: "+bid_price);
			if(bid_price > curr_price) {
				String query3 = "INSERT INTO bid(item_num, email, price) value(?, ?, ?)";
				ps = conn.prepareStatement(query3);
				ps.setInt(1, item_num);
				ps.setString(2, curr_user.getEmail());
				ps.setFloat(3, bid_price);
				ps.executeUpdate();
				email_alert(item_num,conn, session);
			}
		} catch (SQLException e) {
			session.setAttribute("failure_message", "Problem occured at 1 Bid_handler.java!");
				
			}
			finally {
					try {
						if(conn != null) {conn.close();}} 
					catch (SQLException e) {}}}

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
			session.setAttribute("failure_message", "Problem occured at 2 Bid_handler.java!");}
                   finally {try {
                            if(conn != null) {conn.close();}
                       } catch (SQLException e) {}}
	}



}
