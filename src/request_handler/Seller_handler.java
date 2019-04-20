package request_handler;


import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.HttpSession;

import connect.DBConnect;






/**
 * Servlet implementation class Seller_handler
 */
@WebServlet("/Seller_handler")
public class Seller_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Seller_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		HttpSession session = request.getSession();
		String email = (Account_info)session.getAttribute("account_info").getEmail();
		
		String input_title=(String)request.getParameter("title");
		String input_description=(String)request.getParameter("description");
		String input_brand=(String)request.getParameter("brand");
		String input_model=(String)request.getParameter("model");
		String input_item_num = subString(0,9,md5(System.currentTimeMillis()));
		String input_os = (String)request.getParameter("os");
		String input_cpu_core = (String)request.getParameter("cpu_core");
		
		int input_start_price=Integer.parseInt(request.getParameter("start_price"));
		int input_rom=Integer.parseInt(request.getParameter("ram"));
		int input_ram=Integer.parseInt(request.getParameter("rom"));
		
		String item_num = request.getParameter("detail");
		//
		//String email = 
		
		
		DBConnect DB = new DBConnect();
		Connection conn = DB.getConn();
		PreparedStatement prepst = null;
		ResultSet rs = null;
		Statement st=conn.createStatement();

		try {
			int i = st.executeUpdate("insert into item(item_num,,description,'"+city_name+"','"+email+"')");
			out.println("Data is successfully inserted!");

		} catch (SQLException e) {

			e.printStackTrace();

		}
		
	finally {

			try {
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
		
}