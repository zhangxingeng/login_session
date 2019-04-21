package data;

public class List_answer_data {
	private int question_num;
	private String email;
	private String answer;
	
	
	public List_answer_data(int question_num, String email, String answer) {
		super();
		this.question_num = question_num;
		this.email = email;
		this.answer = answer;
	}
	
	public int getQuestion_num() {
		return question_num;
	}
	public void setQuestion_num(int question_num) {
		this.question_num = question_num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
