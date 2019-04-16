package data;
import java.util.Date;

public class List_item_data {
	private String email;
	private String title;
	private String description;
	private String category;
	private char status;
	private float start_price;
	private java.util.Date date;
	private int item_bidamount;
	private String item_num;
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public float getStart_price() {
		return start_price;
	}
	public void setStart_price(float start_price) {
		this.start_price = start_price;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public int getItem_bidamount() {
		return item_bidamount;
	}
	public void setItem_bidamount(int item_bidamount) {
		this.item_bidamount = item_bidamount;
	}
	
}
