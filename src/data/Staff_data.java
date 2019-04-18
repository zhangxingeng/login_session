package data;
import data.Account_data;


public class Staff_data extends Account_data{
	
	public Staff_data(String email, String password) {
		super(email,password,"staff");
	}
}

