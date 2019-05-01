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

@WebServlet("/Search_handler")
public class Search_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search_handler() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query_search = "SELECT * FROM item i , phone_type t WHERE "
				+ "i.brand = t.brand AND i.model = t.model AND i.title LIKE ? ";
		String keyword = "%" + (String)request.getParameter("keyword") + "%";
		ArrayList<List_item_data> search_result = new ArrayList<List_item_data> ();
		try {
			ps = conn.prepareStatement(query_search);
			ps.setString(1, keyword);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				float curr_price = calc_curr_price(rs.getInt("item_num"), conn);
				List_item_data curr = new List_item_data();
						curr.setEmail(rs.getString("email"));
						curr.setTitle(rs.getString("title"));
						curr.setDescription(rs.getString("description"));
						curr.setStatus(rs.getString("status"));
						curr.setStart_price(rs.getFloat("start_price"));
						curr.setTimestamp(rs.getTimestamp("timestamp"));
						//curr.setBid_count(rs.getInt("item_bidamount"));
						curr.setItem_num(rs.getInt("item_num"));
						curr.setBrand(rs.getString("brand"));
						curr.setModel(rs.getString("model"));
						curr.setRam(rs.getInt("ram"));
						curr.setRom(rs.getInt("rom"));
						curr.setOs(rs.getString("os"));
						curr.setCurr_price(curr_price);
						System.out.println("os is : " + curr.getOs());
				search_result.add(curr);
				
				
			}
		}
 		catch (SQLException e1) {
 			session.setAttribute("message", "Problem occured at Search_handler.java!");
 			}finally {
			try {
				if(conn != null) {conn.close();}
			} 
			catch (SQLException e2) {}
			}
		session.setAttribute("search_result", search_result);
		response.sendRedirect("index.jsp");
	}
	
	private float calc_curr_price(int item_num, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT MAX(price) price FROM bids WHERE item_num = ?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, item_num);
		rs = ps.executeQuery();
		float curr_price = (float)(-1);
		if(rs.next()) {
			curr_price = rs.getFloat("price");
		}
		return curr_price;
	}

}
