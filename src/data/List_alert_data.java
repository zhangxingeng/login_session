package data;

public class List_alert_data {
	private String emial;
	private String item_num;
	
	
	public List_alert_data(String emial, String item_num) {
		super();
		this.emial = emial;
		this.item_num = item_num;
	}
	
	
	public String getEmial() {
		return emial;
	}
	public void setEmial(String emial) {
		this.emial = emial;
	}
	public String getItem_num() {
		return item_num;
	}
	public void setItem_num(String item_num) {
		this.item_num = item_num;
	}
}
