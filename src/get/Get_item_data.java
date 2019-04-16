package get;

import java.sql.*;

import java.util.ArrayList;

import data.List_item_data;
import connect.DBConnect;



public class Get_item_data {
	 private ArrayList<List_item_data> item_info=new ArrayList<List_item_data>();
	 /*
	  * This Function searches the string input and search it 
	  */
	 public Get_item_data(String toSearch) {
		 DBConnect DBC = new DBConnect();
			Connection conn = DBC.getConn();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String query = "SELECT * FROM item WHERE (title OR description) LIKE '%?%'" ;
			try {
				ps = conn.prepareStatement(query);
				ps.setString(1, toSearch);
				rs = ps.executeQuery();
				while(rs.next()) {
					List_item_data curr = new List_item_data(rs.getString("email"), 
							rs.getString("title"), rs.getString("description"), 
							rs.getString("category"), rs.getString("status"), 
							rs.getFloat("start_price"), rs.getDate("date"), 
							rs.getInt("item_bidamount"), rs.getString("item_num"));
					item_info.add(curr);//add the object into Linked List
				}
			}
	 		catch (SQLException e1) {
	 		}
	 }
	 /*
	  * This function retrieve list of item data as an object
	  */	 
	 public ArrayList<List_item_data> getResult(){
		 return item_info;
	 }
}
