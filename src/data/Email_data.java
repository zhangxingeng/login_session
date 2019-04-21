package data;

public class Email_data {
	private int message_id;
	private String to_username;
	private String from_username;
	private String message;
	
	public Email_data(int message_id, String to_username, String from_username, String message) {
		super();
		this.message_id = message_id;
		this.from_username = from_username;
		this.to_username = to_username;
		this.message = message;
	}
	
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	
	public String getFrom_username() {
		return from_username;
	}
	public void setFrom_username(String from_username) {
		this.from_username = from_username;
	}
	
	public String getTo_username() {
		return to_username;
	}
	public void setTo_username(String to_username) {
		this.to_username = to_username;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
