package request_handler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.sql.*;
import java.util.LinkedList;

import data.List_answer_data;
import data.List_item_data;
import data.List_question_data;
import connect.DBConnect;

@WebServlet("/Item_detail_handler")
public class Item_detail_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PreparedStatement ps = null;
	ResultSet rs = null;

    public Item_detail_handler() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		HttpSession session = request.getSession();
		List_item_data detail = new List_item_data();

		try {
			int item_num = Integer.parseInt((String)request.getParameter("id"));
			String query_detail = "SELECT * FROM item i, phone_type pt WHERE AND item_num = ? pt.brand = i.brand AND pt.model = i.model";
			ps = conn.prepareStatement(query_detail);
			ps.setInt(1, item_num);
			rs = ps.executeQuery();
			
			detail.setEmail(rs.getString("email"));
			detail.setTitle(rs.getString("title"));
			detail.setDescription(rs.getString("description"));
			detail.setBrand(rs.getString("brand"));
			detail.setModel(rs.getString("model"));
			detail.setOs(rs.getString("os"));
			detail.setRam(rs.getInt("ram"));
			detail.setRom(rs.getInt("rom"));
			detail.setCpu_core(rs.getInt("cpu_core"));
			detail.setStart_price(rs.getFloat("start_price"));
			detail.setStatus(rs.getString("status"));
			detail.setCurr_price(calc_curr_price(item_num, conn));
			detail.setBid_count(calc_bid_amount(item_num, conn));
			
			session.setAttribute("item_detail", detail);
						
			/********Then get all the questions and answers*********/
			String qus_query="SELECT q.question FROM question q WHERE q.item_num = ?";
			ps = conn.prepareStatement(qus_query);
			ps.setInt(1, item_num);
			rs = ps.executeQuery();
			LinkedList<List_question_data> questions = new LinkedList<List_question_data>();
			while(rs.next()) {
				List_question_data question = new List_question_data();
				question.setQuestion(rs.getString("question"));
				question.setEmail(rs.getString("email"));
				
				String ans_query= "SELECT * FROM answer a, question q WHERE a.question_num = q.question_num = ?";
				ps = conn.prepareStatement(ans_query);
				ps.setInt(1, rs.getInt("question_num"));
				ResultSet rs2 = ps.executeQuery();
				LinkedList<List_answer_data> answers = new LinkedList<List_answer_data>();
				while(rs2.next()) {
					List_answer_data answer = new List_answer_data();
					answer.setAnswer(rs.getString("answer"));
					answer.setEmail(rs.getString("email"));
					answers.add(answer);
				}
				question.setAnswers(answers);
				questions.add(question);
			}
			
			session.setAttribute("questions", questions);		
		} catch (Exception e) {}
   		finally {
   			try {if(conn != null) {conn.close();}} 
   			catch (Exception e4) {}
   		}
	}
	private int calc_bid_amount(int item_num, Connection conn) {
		String bid_count_query = "SELECT count(*) FROM bids b, item i WHERE i.item_num = b.item_num = ?";
   		try {
			ps = conn.prepareStatement(bid_count_query);
			ps.setInt(1, item_num);
			rs = ps.executeQuery();
			return rs.getInt(1);
		} catch (SQLException e) {}
		return -1;
	}
	private float calc_curr_price(int item_num, Connection conn) {
		String curr_price_query = "SELECT MAX(price) FROM bids WHERE item_num = ?";
		try {
			ps = conn.prepareStatement(curr_price_query);
			ps.setInt(1, item_num);
			rs = ps.executeQuery();
			return rs.getFloat(1);
		} catch (SQLException e) {}
		return -1;
	}
}