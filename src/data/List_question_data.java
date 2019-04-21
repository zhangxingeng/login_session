package data;

public class List_question_data {
	private int question_num;
	private int item_num;
	private String email;
	private String question;
	
	
	public List_question_data(int question_num, int item_num, String email, String question) {
		super();
		this.question_num = question_num;
		this.item_num = item_num;
		this.email = email;
		this.question = question;
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
	
	
}
