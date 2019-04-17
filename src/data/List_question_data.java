package data;

public class List_question_data {
	private String question_num;
	private String item_num;
	private String email;
	private String question;
	
	
	public List_question_data(String question_num, String item_num, String email, String question) {
		super();
		this.question_num = question_num;
		this.item_num = item_num;
		this.email = email;
		this.question = question;
	}
	
	public String getQuestion_num() {
		return question_num;
	}
	public void setQuestion_num(String question_num) {
		this.question_num = question_num;
	}
	public String getItem_num() {
		return item_num;
	}
	public void setItem_num(String item_num) {
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
