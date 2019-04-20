package data;
public class Account_data {
	
	protected String email;
	protected String password;
	protected String type;
	private String name;
	private String address;
	private String state;
	private String zip;
	private String phone_num;
	
	
	/*
	 * this constructor can create users
	 */
	public Account_data(String email, String password, String name, String address, String state, String zip,
			String phone_num) {
		this.email = email;
		this.password = password;
		this.type = "user";
		this.name = name;
		this.address = address;
		this.state = state;
		this.zip = zip;
		this.phone_num = phone_num;
	}
	/*
	 * this constructor can create all types of account
	 */
	public Account_data(String email, String password, String type) {
		this.email = email;
		this.password = password;
		this.type = type;
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
