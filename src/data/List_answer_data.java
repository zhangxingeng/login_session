package data;

public class List_answer_data {
	private String email;
	private String answer;
	
	
	public List_answer_data(int question_num, String email, String answer) {
		this.email = email;
		this.answer = answer;
	}
	
	public List_answer_data() {
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
