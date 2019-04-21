package request_handler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.DBConnect;
import data.List_item_data;

@WebServlet("/Search_Response")
public class Search_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Search_handler() {
        super();
    }

	/**
	 * This function takes the input String and query it from database
	 * attribute "search_result" is updated per request
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<List_item_data> item_info=new ArrayList<List_item_data>();
		HttpSession session = request.getSession();
		Float min_price = Float.parseFloat(request.getParameter("min_price"));
		Float max_price = Float.parseFloat(request.getParameter("max_price"));
		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String k = request.getParameter("keyword");
		String b = request.getParameter("brand");
		String m = request.getParameter("model");
		String status = request.getParameter("status");
		String query = 	"SELECT * "
					+ 	"FROM item i"
					+ 	"WHERE (i.title OR i.description) LIKE '%?%' "
					+ 	"AND i.brand LIKE '%?%' "
					+ 	"AND i.model LIKE '%?%' "
					+ 	"AND i.curr_price > ? "
					+ 	"AND i.curr_price < ? "
					+ 	"AND i.status = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, k);
			ps.setString(2, b);
			ps.setString(3, m);
			ps.setFloat(4, min_price);
			ps.setFloat(5, max_price);
			ps.setString(6, status);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				//todo:query from bid for highest price save into curr_price
				float curr_price = calc_curr_price(rs.getString("item_num"), conn);
				
				List_item_data curr = new List_item_data(rs.getString("email"), 
						rs.getString("title"), rs.getString("description"), 
						rs.getString("status"), 
						rs.getFloat("start_price"), rs.getTimestamp("timestamp"), 
						rs.getInt("item_bidamount"), rs.getInt("item_num"), 
						rs.getString("brand"), rs.getString("model"),
						rs.getInt("ram"), rs.getInt("rom"),
						rs.getString("os"),
						curr_price);
				item_info.add(curr);//add the object into Linked List
			}
		}

 		catch (SQLException e1) {
 			session.setAttribute("failure_message", "Problem occured at Search_handler.java!");
 			}finally {
			try {
				if(conn != null) {conn.close();}} 
			catch (SQLException e2) {}}
		
		
		if(session.getAttribute("search_result") != null) {
			session.removeAttribute("search_result");
		}
		session.setAttribute("search_result", item_info);
		response.sendRedirect("login_control/index.jsp");
	}
	
	private float calc_curr_price(String item_num, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT MAX(price) FROM bids WHERE item_num = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, item_num);
		rs = ps.executeQuery();
		float curr_price = rs.getFloat("price");
		return curr_price;
	}
}

