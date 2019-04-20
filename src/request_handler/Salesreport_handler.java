package request_handler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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
 * Servlet implementation class Salesreport_handler
 */
@WebServlet("/Salesreport_handler")
public class Salesreport_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Salesreport_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
        HttpSession session = request.getSession();
        
		DBConnect DB = new DBConnect();
		Connection con = DB.getConn();
		PreparedStatement prepst = null;
		ResultSet rs = null;
		try {
			float start_price = 0;
			float soldprice = 0;
			float total_earning = 0; 
			String Sumsql = "SELECT item_num,SUM(start_price) FROM item GROUP BY item_num HAVING status = 'sold'";
			prepst = con.prepareStatement(Sumsql);
			
			prepst.setLong(1,(long) start_price);
			
			String Soldsql = "SELECT item_num,SUM(curr_price) FROM item GROUP BY item_num HAVING status ='sold'";
			prepst = con.prepareStatement(Soldsql);
			prepst.setLong(1,(long) soldprice);
			
			rs = prepst.executeQuery();
			if(!rs.next()) {
				
				total_earning = soldprice - start_price;
				
				String insertSQL = "INSERT INTO item(item_bidamount) VALUES (?)";
				prepst = con.prepareStatement(insertSQL);
				prepst.setLong(1,(long) total_earning);
				
				prepst.executeUpdate();
				
				
			}else {
				System.out.println("error occurred");//error occurred
            	response.sendRedirect("admin_home.jsp");//redirict register
			
			
		}}
		catch(SQLException e){
			e.printStackTrace();
		}
		
			
	}
	}


