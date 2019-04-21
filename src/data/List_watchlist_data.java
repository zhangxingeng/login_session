package data;

public class List_watchlist_data {
	private String email;
	private String item_num;
	
	
	public List_watchlist_data(String email, String item_num) {
		super();
		this.email = email;
		this.item_num = item_num;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getItem_num() {
		return item_num;
	}
	public void setItem_num(String item_num) {
		this.item_num = item_num;
	}
	
}
