package data;

public class List_purchase_data {
	private int item_num;
	private int buyer_num;
	private int seller_num;
	private int fdbk_buyer;
	private int fdbk_seller;
	
	
	
	public List_purchase_data(int item_num, int buyer_num, int seller_num, int fdbk_buyer, int fdbk_seller) {
		super();
		this.item_num = item_num;
		this.buyer_num = buyer_num;
		this.seller_num = seller_num;
		this.fdbk_buyer = fdbk_buyer;
		this.fdbk_seller = fdbk_seller;
	}
	
	
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	public int getBuyer_num() {
		return buyer_num;
	}
	public void setBuyer_num(int buyer_num) {
		this.buyer_num = buyer_num;
	}
	public int getSeller_num() {
		return seller_num;
	}
	public void setSeller_num(int seller_num) {
		this.seller_num = seller_num;
	}
	public int getFdbk_buyer() {
		return fdbk_buyer;
	}
	public void setFdbk_buyer(int fdbk_buyer) {
		this.fdbk_buyer = fdbk_buyer;
	}
	public int getFdbk_seller() {
		return fdbk_seller;
	}
	public void setFdbk_seller(int fdbk_seller) {
		this.fdbk_seller = fdbk_seller;
	}
	
	
}
