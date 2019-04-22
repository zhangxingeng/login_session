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
	
	public static Date addDay(Date date) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.DAY_OF_YEAR, 7);
	        return cal.getTime();
	    }
	
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

		DBConnect dbc = new DBConnect();
		Connection conn = dbc.getConn();
		PreparedStatement ps = null;

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
			
			 Date now = new Date(System.currentTimeMillis());
			 TimerTask task = new TimerTask() {
		           @Override
		           public void run() { 
		          
		         
		           }
		       };
		       Timer timer = new Timer();		     
			   timer.schedule(task, addDay(now));
		 
	      
		} catch (SQLException e1) {session.setAttribute("failure_info", "add item has failed. check Seller_handler.java");}
		finally {
			session.setAttribute("success_info", "add item is a success!");
				try {
					if(conn != null) {conn.close();}
				} catch (SQLException e) {}
				}
		}
	
	/*************ADD 2 TASKS HERE
	 * 1. set attribute to application: end of auction task,
	 * 2. 24h before task do st to watchlist
	 * 
	 * ******************/
	public static void end_auction(Connection conn, int item_num) {
		/*query item, change status from a to:
		 * 1. if sold, s, message buyer
		 * 2. if max bid < reserve bid, f
		 *message user about success/failed
		 */
		
	}
	
	public static void alert_watchlist(Connection conn, int item_num) {
	
	}
	/*
	 * send message to watchlister item about to be sold!
	 */
	
	
	
	
	
	
	
	}



























