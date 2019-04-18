package data;
import data.Account_data;

public class Admin_data extends Account_data{
	
	public Admin_data(String email, String password) {
		super(email,password,"admin");
	}
}
