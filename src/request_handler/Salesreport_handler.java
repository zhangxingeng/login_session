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

		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String report = request.getParameter("report");
			if(report.equals("totalearning")) {

				String query_sum= "SELECT SUM（T.maxp）*0.04 FROM (SELECT item_num,Max(b.price) maxp FROM bids b WHERE b.status = 's' GROUP BY item_num) AS T";
				 ps = conn.prepareStatement(query_sum);
				 rs = ps.executeQuery();
				float total_earning = rs.getFloat(1);

				session.setAttribute("total_earning", total_earning);

			}else if(report.equals("earnperitem")) {

				String q_earning_per_item= "SELECT item_num,Max(b.price)*0.04 maxp FROM bids b WHERE b.status = 's' GROUP BY item_num";

				 ps= conn.prepareStatement(q_earning_per_item);
				 rs = ps.executeQuery();
				float earning_per_item = rs.getFloat(1);

				session.setAttribute("earning_per_item", earning_per_item);


			}else if(report.equals("earnpertype")) {

			String earing_per_itemtype = "SELECT brand, model ,SUM(curr.max)*0.04 FROM (SELECT brand, model, MAX(b.price) max FROM item i, bids b WHERE i.brand = b.brand, i.mpodel = b.model GROUP BY item_num) AS curr GROUP BY(curr.brand,curr.model) SORT BY i.brand, i.model";

			 ps= conn.prepareStatement(earing_per_itemtype);
			 rs = ps.executeQuery();
			float earing_per_item_type = rs.getFloat(1);

			session.setAttribute("earing_per_item_type", earing_per_item_type);


			}else if(report.equals("earnperuser")) {

				String earing_per_enduser = "";

				 ps= conn.prepareStatement(earing_per_enduser);
				 rs = ps.executeQuery();
				float earing_per_end_user = rs.getFloat(1);

				session.setAttribute("earing_per_end_user", earing_per_end_user);

			}else if(report.equals("bestsellitem")) {

				String bestsellitem = "";

				 ps= conn.prepareStatement(bestsellitem);
				 rs = ps.executeQuery();
				String bestselling_item = rs.getString(1);

				session.setAttribute("bestselling_item", bestselling_item);

			}else if(report.equals("bestuser")) {

				String bestuser = "";

				 ps= conn.prepareStatement(bestuser);
				 rs = ps.executeQuery();
				String best_buyers = rs.getString(1);

				session.setAttribute("best_buyers", best_buyers);

			}else {}
            response.sendRedirect("admin_home.jsp");
		}
		catch(SQLException e){
			session.setAttribute("failure_message", "Problem occured at Salesreport_handler.java!");

		}finally {try {if(conn != null) {conn.close();}
	} catch (SQLException e) {}
		}
	}
}
