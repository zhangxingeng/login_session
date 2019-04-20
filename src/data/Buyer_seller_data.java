package data;

public class Buyer_seller_data {
	private String seller_num;
	private String email;
	private int fdbk;
	
	
	public Buyer_seller_data(String seller_num, String email, int fdbk) {
		super();
		this.seller_num = seller_num;
		this.email = email;
		this.fdbk = fdbk;
	}
	
	
	public String getSeller_num() {
		return seller_num;
	}
	public void setSeller_num(String seller_num) {
		this.seller_num = seller_num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getFdbk() {
		return fdbk;
	}
	public void setFdbk(int fdbk) {
		this.fdbk = fdbk;
	}
}
