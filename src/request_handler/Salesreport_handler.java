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
			String report = request.getParameter("report");
			if(report.equals("totalearning")) {
				float start_price = 0;
				float sold_price = 0;
				float total_earning = 0; 
				
				float curr_price= 000000;//TODO: calc curr price from all bids
				String query_start = "SELECT item_num,SUM(start_price) FROM item AND status = 'sold'";
				String query_end = "SELECT item_num,SUM(?) FROM item AND status ='sold'";
				
				PreparedStatement ps_start = con.prepareStatement(query_start);
				PreparedStatement ps_end = con.prepareStatement(query_end);
				
				
				ResultSet rs_start = ps_start.executeQuery();
				ResultSet rs_end = ps_end.executeQuery();
				
				
				start_price = rs_start.getFloat(1);
				sold_price = rs_end.getFloat(1);
				total_earning = sold_price - start_price;
				
				session.setAttribute("total_earning", total_earning);
				
			}else if(report.equals("earnperitem")) {
				
				
				
				
				
				
				
			}else if(report.equals("earnpertype")) {
				
				
				
				
				
			}else if(report.equals("earnperuser")) {
				
			}else if(report.equals("bestsellitem")) {
				
			}else if(report.equals("bestuser")) {
				
			}else {}
            response.sendRedirect("admin_home.jsp");	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
			
	}
	}


