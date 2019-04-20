package request_handler;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		
		String input_title=(String)request.getParameter("title");
		String input_description=(String)request.getParameter("description");
		String input_catagory=(String)request.getParameter("catagory");
		String input_model=(String)request.getParameter("model");
		String input_start_price=(String)request.getParameter("start_price");
		DBConnect DB = new DBConnect();
		Connection con = DB.getConn();
		PreparedStatement prepst = null;
		ResultSet rs = null;
		int item_num_int = Integer.parseInt(request.getParameter("item_num")); 
		item_num_int ++;
		String item_num = Integer.toString(item_num_int);
		 

		try {
			String selectSQL = "SELECT item_num FROM item WHERE item_num=?";
			prepst = con.prepareStatement(selectSQL);
			prepst.setString(1,item_num);

			// execute select SQL stetement
		   rs = prepst.executeQuery();

			if (!rs.next()) {
				String insertSQL = "INSERT INTO user(email, password,username,address) VALUES (?, ?, ?, ?)";
				prepst = con.prepareStatement(insertSQL);
				prepst.setString(1,input_title);
				prepst.setString(2,input_description);
				prepst.setString(3,input_catagory);
				prepst.setString(4,input_start_price);
                int i= prepst.executeUpdate();
                if(i != 0 ) {
                	System.out.println("successed!");//success
                	response.sendRedirect("index.jsp");//redirect index
                }else {
                	System.out.println("error occurred");//error occurred
                	response.sendRedirect("error.jsp");//redirict register
                }
			}else {
				System.out.println("Go back to home page");//this email alreay exists
				response.sendRedirect("index.jsp");//redirct register
			}

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