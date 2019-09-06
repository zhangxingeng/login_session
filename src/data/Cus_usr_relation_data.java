package data;

public class Cus_usr_relation_data {
	private String cus_email;
	private String email;
	
	
	public Cus_usr_relation_data(String cus_email, String email) {
		super();
		this.cus_email = cus_email;
		this.email = email;
	}
	
	
	public String getCus_email() {
		return cus_email;
	}
	public void setCus_email(String cus_email) {
		this.cus_email = cus_email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
