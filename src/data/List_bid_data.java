package data;


import java.sql.Timestamp;

public class List_bid_data {
	private int item_num;
	private String email;
	private float price;
	private Timestamp TIMESTAMP;
	
	
	
	public List_bid_data(int item_num, String email, float price, Timestamp TIMESTAMP) {
		super();
		this.item_num = item_num;
		this.email = email;
		this.price = price;
		this.TIMESTAMP = TIMESTAMP;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public java.util.Date getTIMESTAMP() {
		return TIMESTAMP;
	}
	public void setTIMESTAMP(Timestamp TIMESTAMP) {
		this.TIMESTAMP = TIMESTAMP;
	}
	
	
	
	
}
