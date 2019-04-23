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
		String email = ((Account_data)session.getAttribute("account_info")).getEmail();
		String title=(String)request.getParameter("title");
		String description=(String)request.getParameter("description");
		String brand=(String)request.getParameter("brand");
		String model=(String)request.getParameter("model");
		float start_price=Integer.parseInt(request.getParameter("start_price"));

		String os = (String)request.getParameter("os");
		String cpu_core = (String)request.getParameter("cpu_core");
		int rom=Integer.parseInt(request.getParameter("ram"));
		int ram=Integer.parseInt(request.getParameter("rom"));

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String query_add_new_phone_type = "INSERT INTO phone_type (brand, model, ram, rom, cpu_core, os) VALUES (?,?,?,?,?,?)";
			ps = conn.prepareStatement(query_add_new_phone_type);
			ps.setString(1, brand);
			ps.setString(2, model);
			ps.setInt(3, ram);
			ps.setInt(4, rom);
			ps.setString(5, cpu_core);
			ps.setString(6, os);
			ps.executeUpdate();
		} catch (SQLException e1) {session.setAttribute("duplicate_info", "this brand and type is already added.");}
		try {
			String query_upload_item = "INSERT INTO item (email,title,description,brand,model,status,start_price) VALUES (?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query_upload_item);
			ps.setString(1, email);
			ps.setString(2, title);
			ps.setString(3, description);
			ps.setString(4, brand);
			ps.setString(5, model);
			ps.setString(6, "a");
			ps.setFloat(7, start_price);
			ps.executeUpdate();
			String query_item_num ="SELECT TOP 1 item_num FROM item ORDER BY date DESC";
			ps = conn.prepareStatement(query_item_num);
			rs = ps.executeQuery();
			int item_num = rs.getInt("ite_num");
			
			
			 Date now = new Date(System.currentTimeMillis());
			 TimerTask task = new TimerTask() {
		           @Override
		           public void run() { 
		        	   end_auction(conn, item_num);
		           }
		       };
		       Timer timer = new Timer();		     
			   timer.schedule(task, addDay(now,7));
			   request.getServletContext().setAttribute("task"+item_num,timer);
			   
			   
	      
		} catch (SQLException e1) {session.setAttribute("failure_info", "add item has failed. check Seller_handler.java");}
		finally {
			session.setAttribute("success_info", "add item is a success!");
				try {
					if(conn != null) {conn.close();}
				} catch (SQLException e) {}
				}
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
	
	public static Date addDay(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, day);
        return cal.getTime();
    }
}



























