package data;
import java.util.LinkedList;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;


public class List_question_data {
	private int question_num;
	private int item_num;
	private String email;
	private String question;
	LinkedList<List_answer_data> answers;
	
	public List_question_data() {
	}
	
	public int getQuestion_num() {
		return question_num;
	}
	public void setQuestion_num(int question_num) {
		this.question_num = question_num;
	}
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public LinkedList<List_answer_data> getAnswers() {
		return answers;
	}
	public void setAnswers(LinkedList<List_answer_data> answers) {
		this.answers = answers;
	}
	
	
}
	
