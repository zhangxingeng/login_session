package data;


public class Staff_data{
	protected String email;
	protected String password;
	protected String type;
	
	public Staff_data(String email, String password, String type) {
		this.email = email;
		this.password = password;
		this.type = type;
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

