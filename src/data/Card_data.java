package data;

import java.util.Date;

public class Card_data {
	private String email;
	private String card_num;
	private String name;
	private String address;
	private String state;
	private String zip;
	private java.util.Date experiation_date;
	private String cvv;
	
	
	public Card_data(String email, String card_num, String name, String address, String state, String zip,
			Date experiation_date, String cvv) {
		super();
		this.email = email;
		this.card_num = card_num;
		this.name = name;
		this.address = address;
		this.state = state;
		this.zip = zip;
		this.experiation_date = experiation_date;
		this.cvv = cvv;
		
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCard_num() {
		return card_num;
	}
	public void setCard_num(String card_num) {
		this.card_num = card_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public java.util.Date getExperiation_date() {
		return experiation_date;
	}
	public void setExperiation_date(java.util.Date experiation_date) {
		this.experiation_date = experiation_date;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	
}

