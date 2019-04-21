package data;

public class List_alert_data {
	private String email;
	private int item_num;
	
	
	public List_alert_data(String email, int item_num) {
		super();
		this.email = email;
		this.item_num = item_num;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmial(String email) {
		this.email = email;
	}
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
}
