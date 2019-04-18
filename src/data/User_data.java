package data;
import data.Account_data;
public class User_data extends Account_data{
	
	private String name;
	private String address;
	private String state;
	private String zip;
	private String phone_num;
	
	public User_data(String email, String password, String name, String address, String state, String zip,
			String phone_num) {
		super(email,password,"user");
		this.name = name;
		this.address = address;
		this.state = state;
		this.zip = zip;
		this.phone_num = phone_num;
	}
	
	public String getType() {
		return super.type;
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
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	
}
