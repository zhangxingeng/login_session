package request_handler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.DBConnect;
import data.Account_data;
import data.List_answer_data;
import data.List_item_data;
import data.List_question_data;

@WebServlet("/Bid_handler")
public class Bid_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Bid_handler() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		HttpSession session = request.getSession();
		int item_num = (int) request.getAttribute("item_num");//TODO
		String query_qandas="SELECT q.question FROM question q WHERE q.item_num = ?";
		ps = conn.prepareStatement(query_qandas);
		rs = ps.executeQuery();
		
		LinkedList<List_question_data> question_list = new LinkedList<List_question_data>();
		while(rs.next()) {
			List_question_data question = new List_question_data();
			question.setQuestion(rs.getString("question"));
			
			LinkedList<List_answer_data> answer_list = new LinkedList<List_answer_data>();
			question.setAnswers(answer_list);
			String ans_query= "SELECT * FROM answer a, question q WHERE a.question_num = q.question_num = ?";
			ps.setString(1, item_num);
			ResultSet temp_rs = ps.executeQuery();
			while(temp_rs.next()) {
				List_answer_data a= new List_answer_data();
				a.getAnswer(rs.getString("answer"));
				a.getEmail(rs.getString("email"));
				answer_list.add(a);
			}
			question.setAnswers(answer_list);
			question_list.add(question);
		}
		session.setAttribute("questions", question_list);
	}
}

	
	
	
	
	
	
	
	
	
	
	
	