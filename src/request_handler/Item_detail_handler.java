package request_handler;

import java.io.*; 


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.sql.*;
import javax.servlet.*;
import data.Item_detail_data;
import connect.DBConnect;




/**
 * Servlet implementation class Item_detail_handler
 */
@WebServlet("/Item_detail_handler")
public class Item_detail_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Item_detail_handler() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		HttpSession session = request.getSession();
		
		Item_detail_data item_detail = (Item_detail_data)(session.getAttribute("Item_detail_info"));
		
		String title = item_detail.getTitle();
		String description = item_detail.description();
		String model = item_detail.getModel();
		String brand = item_detail.getBrand();
		String os = item_detail.Os();
		int ram = item_detail.getRam();
		int rom = item_detail.getRom();
		double start_price = item_detail.getStart_price();
		String cpu_core = item_detail.getCpu_core();;
		String question = item_detail.getQuestion();
		String answer = item_detail.getAnswer();
		double curr_bid = item_detail.getCurr_bid();
		int bid_count = item_detail.getBid_count();
		double your_bid = item_detail.getYour_bid();
		List_question_data quest = (List_question_data)(session.getAttribute("List_question_info"));
    	List_answer_data ans = (List_answer_data)(session.getAttribute("List_answer_info"));
   		
		
		try {
			String user = curr_user.getName();
			String item_num = request.getParameter("detail");
			String itemQuery = "SELECT * FROM item i, phone_type pt WHERE AND item_num = ? pt.brand = i.brand AND pt.model = i.model";
			ps = conn.prepareStatement(itemQuery);
			ps.addString(item_num);
			rs = ps.executeQuery();
			while (rs.next()) {
				rs.getString("title");
				rs.getString("description");
				rs.getString("model");
				rs.getString("os");
				rs.getString("brand");
				rs.getInt("ram");
				rs.getInt("rom");
				rs.getString("cpu_core");
				rs.getDouble("start_price");
			}
		} catch (Exception e) {
    	try{
   			String q_quest_num = quest.getQuestion_num();
   			String q_item_num = quest.getItem_num();
   			String a_quest_num = ans.getQuestion_num();
    		String item_num = request.getParameter("detail");
    			
   			String q_and_a_query = "select q.question, a.answer from item i, question q, answer a whwre i.item_num = ? AND (i.item_num = q.item_num AND (q.question_num = a.question_num))"; 
   			ps = conn.prepareStatement(q_and_a_query);
			rs = ps.executeQuery();
			while(rs.next()){
				rs.getString("question");
				rs.getString("answer");
			}
   		} catch (Exception e1) {
   		try{
   			String bid_count_query = "SELECT count(*) FROM bids b, item i WHERE i.item_num = ? ADN ? = b.item_num";
   			ps = conn.prepareStatement(bid_count_query);
   			rs = ps.executeQuery();
   			String count="";
   			while(rs.next()){
   				count = rs.getString(1);
   				System.out.println("Total Number of Bids: " +count);
   			}
   		}catch (Exception e2){
   		try{
   			String curr_price_query = "SELECT MAX(price) FROM bids WHERE ";
   			ps = conn.prepareStatement(curr_price_query);
   			rs = ps.executeQuery();
   			while(rs.next()){
   				rs.getString("price");	
   			}

   		}catch (Exception e3){
   			
			session.setAttribute("failure_message", "Problem occured at  Item_detail_handler.java!");


   		}}
   		finally {
   			try {if(conn != null) {conn.close();}
   			} catch (Exception e4) {}}}}}}
