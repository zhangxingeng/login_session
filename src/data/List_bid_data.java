package data;

import java.util.Date;

public class List_bid_data {
	private String item_num;
	private String email;
	private float price;
	private java.util.Date date;
	
	
	
	public List_bid_data(String item_num, String email, float price, Date date) {
		super();
		this.item_num = item_num;
		this.email = email;
		this.price = price;
		this.date = date;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	
	
	
	
}
