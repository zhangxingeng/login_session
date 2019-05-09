package request_handler;

import java.util.*;
import java.util.Date;
import java.io.IOException;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringEscapeUtils;

import connect.DBConnect;
import data.Account_data;


@WebServlet("/Seller_handler")
public class Item_upload_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBConnect dbc = new DBConnect();
	Connection conn = dbc.getConn();
	
    public Item_upload_handler() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if(session.getAttribute("account_info") == null) {
			session.setAttribute("message", "please log in first.");
			response.sendRedirect("index.jsp");
			return;
		}
		String email = ((Account_data)session.getAttribute("account_info")).getEmail();
		String title=(String)request.getParameter("title");
		title = StringEscapeUtils.escapeJava(title);
		String description=(String)request.getParameter("description");
		description = StringEscapeUtils.escapeJava(description);
		
		String model=(String)request.getParameter("model");
		float start_price=Integer.parseInt(request.getParameter("start_price"));

		String os = (String)request.getParameter("os");
		String cpu_core = (String)request.getParameter("cpu_core");
		int rom=Integer.parseInt(request.getParameter("ram"));
		int ram=Integer.parseInt(request.getParameter("rom"));
		String brand=(String)request.getParameter("brand");
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String query_add_new_phone_type = "INSERT IGNORE INTO phone_type (brand, model, ram, rom, cpu_core, os) VALUES (?,?,?,?,?,?)";
			ps = conn.prepareStatement(query_add_new_phone_type);
			ps.setString(1, brand);
			ps.setString(2, model);
			ps.setInt(3, ram);
			ps.setInt(4, rom);
			ps.setString(5, cpu_core);
			ps.setString(6, os);
			ps.executeUpdate();
		} catch (SQLException e1) {session.setAttribute("message", "this brand and type is already added.");}
		try {
			String query_upload_item = "INSERT IGNORE INTO item (email,title,description,brand,model,status,start_price) VALUES (?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query_upload_item);
			ps.setString(1, email);
			ps.setString(2, title);
			ps.setString(3, description);
			ps.setString(4, brand);
			ps.setString(5, model);
			ps.setString(6, "a");
			ps.setFloat(7, start_price);
			System.out.println(ps.toString());
			ps.executeUpdate();
		}catch (SQLException e1) {}
		try {
			String query_item_num ="SELECT item_num FROM item WHERE email = ? ORDER BY timestamp DESC LIMIT 1";
			ps = conn.prepareStatement(query_item_num);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if(rs.next()) {
				int item_num = rs.getInt("item_num");
				set_timer(item_num, 7, request, conn);
				session.setAttribute("message", "add item is a success!");
				response.sendRedirect("item_upload.jsp");
			}else {
				session.setAttribute("message", "add item has failed. check Seller_handler.java");
			}
		} catch (SQLException e1) {}
		finally {
				try {
					if(conn != null) {conn.close();}
				} catch (SQLException e) {}
				}
		}
	
	
	
	public static boolean set_timer(int item_num, int days, HttpServletRequest request, Connection conn) throws SQLException{
		 TimerTask task = new TimerTask() {
	           @Override
	           public void run() { 
	        	   end_auction(conn, item_num);
	           }
	       };
	       Timer timer = new Timer();	
	       Date now = new Date(System.currentTimeMillis());
	       
		   timer.schedule(task, delay_days(now,days));
		   request.getServletContext().setAttribute("task"+item_num,timer);
		   return true;
	}
	
	public static void end_auction(Connection conn, int item_num) {
		String end_auction = "UPDATE item i SET i.status = ? WHERE i.item_num =?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(end_auction);
			ps.setString(1, "s");
			ps.setInt(2, item_num);
			ps.executeQuery();
		} catch (SQLException e) {}
	}
	
	public static Date delay_days(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, day);
        return cal.getTime();
    }
}



























