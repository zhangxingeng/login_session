package get;

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




/**
 * Servlet implementation class Search_Response
 */
@WebServlet("/Search_Response")
public class Search_Response extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Search_Response() {
        super();
    }

	/**
	 * This function takes the input String and query it from database
	 * attribute "search_result" is updated per request
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<List_item_data> item_info=new ArrayList<List_item_data>();
		
		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String input = request.getParameter("search");
		String query = "SELECT * FROM item WHERE (title OR description) LIKE '%?%'" ;
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, input);
			rs = ps.executeQuery();
			while(rs.next()) {
				List_item_data curr = new List_item_data(rs.getString("email"), 
						rs.getString("title"), rs.getString("description"), 
						rs.getString("category"), rs.getString("status"), 
						rs.getFloat("start_price"), rs.getDate("date"), 
						rs.getInt("item_bidamount"), rs.getString("item_num"));
				item_info.add(curr);//add the object into Linked List
			}
		}
 		catch (SQLException e1) {
 		}
		
		HttpSession session = request.getSession();
		if(session.getAttribute("search_result") != null) {
			session.removeAttribute("search_resultsearch_result");
		}
		session.setAttribute("search_result", item_info);
		response.sendRedirect("login_control/index.jsp");
		
	}
}





