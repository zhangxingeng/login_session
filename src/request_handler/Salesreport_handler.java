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
				
				String query_sum= "SELECT SUM（T.maxp）*0.04 FROM (SELECT item_num,Max(b.price) maxp FROM bid b WHERE b.status = 's' GROUP BY item_num) AS T";
				PreparedStatement ps_sum = con.prepareStatement(query_sum);
				ResultSet rs_sum = ps_sum.executeQuery();
				float total_earning = rs_sum.getFloat(1);
				
				session.setAttribute("total_earning", total_earning);
				
			}else if(report.equals("earnperitem")) {
				
				String earningper_item= "SELECT item_num,Max(b.price)*0.04 maxp FROM bid b WHERE b.status = 's' GROUP BY item_num";
				
				PreparedStatement ps_earningper_item= con.prepareStatement(earningper_item);
				ResultSet rs_earningper_item = ps_earningper_item.executeQuery();
				float earning_per_item = rs_earningper_item.getFloat(1); 
				
				session.setAttribute("earning_per_item", earning_per_item);
				
			
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


