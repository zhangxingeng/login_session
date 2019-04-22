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

import data.Account_data;
import data.Item_detail_data;
import data.List_item_data;
import connect.DBConnect;


@WebServlet("/Item_detail_handler")
public class Item_detail_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Item_detail_handler() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		HttpSession session = request.getSession();
		
		List_item_data detail = new List_item_data();
		

		

		detail.setQuestion();
		detail.setAnswer();
		detail.setCurr_bid();
		detail.setBid_count();
		detail.setYour_bid();
		
   		
		
		try {
			int item_num = Integer.parseInt((String)request.getAttribute("item_num"));
			Account_data curr_user = (Account_data)session.getAttribute("account_info");
			String query_detail = "SELECT * FROM item i, phone_type pt WHERE AND item_num = ? pt.brand = i.brand AND pt.model = i.model";
			ps = conn.prepareStatement(query_detail);
			ps.setInt(1, item_num);
			rs = ps.executeQuery();
			while (rs.next()) {
				detail.setTitle(rs.getString("title"));
				detail.setDescription(rs.getString("description"));
				detail.setBrand(rs.getString("brand"));
				detail.setModel(rs.getString("model"));
				detail.setOs(rs.getString("os"));
				detail.setRam(rs.getInt("ram"));
				detail.setRom(rs.getInt("rom"));
				detail.setCpu_core(rs.getInt("cpu_core"));
				detail.setStart_price(rs.getFloat("start_price"));
			}
		} catch (Exception e) {
    	try{
   			String q_quest_num = quest.setQuestion_num();
   			String q_item_num = quest.setItem_num();
   			String a_quest_num = ans.setQuestion_num();
    		String item_num = request.setParameter("detail");
    			
   			String q_and_a_query = "select q.question, a.answer from item i, question q, answer a whwre i.item_num = ? AND (i.item_num = q.item_num AND (q.question_num = a.question_num))"; 
   			ps = conn.prepareStatement(q_and_a_query);
			rs = ps.executeQuery();
			while(rs.next()){
				rs.setString("question");
				rs.setString("answer");
			}
   		} catch (Exception e1) {
   		try{
   			String bid_count_query = "SELECT count(*) FROM bids b, item i WHERE i.item_num = ? ADN ? = b.item_num";
   			ps = conn.prepareStatement(bid_count_query);
   			rs = ps.executeQuery();
   			String count="";
   			while(rs.next()){
   				count = rs.setString(1);
   				System.out.println("Total Number of Bids: " +count);
   			}
   		}catch (Exception e2){
   		try{
   			String curr_price_query = "SELECT MAX(price) FROM bids WHERE ";
   			ps = conn.prepareStatement(curr_price_query);
   			rs = ps.executeQuery();
   			while(rs.next()){
   				rs.setString("price");	
   			}

   		}catch (Exception e3){
   			
			session.setAttribute("failure_message", "Problem occured at  Item_detail_handler.java!");


   		}}
   		finally {
   			try {if(conn != null) {conn.close();}
   			} catch (Exception e4) {}}}}}}
