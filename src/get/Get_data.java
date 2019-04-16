package get;

import java.sql.*;
import java.util.ArrayList;

import data.List_item_data;
import connect.DBConnect;



public class Get_data {
	 private ArrayList<List_item_data> item_info=new ArrayList<List_item_data>();
	 public Get_data(String toSearch) {
		 DBConnect DBC = new DBConnect();
			Connection conn = DBC.getConn();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String query = "SELECT * FROM item WHERE name LIKE '%?%";
			try {
				ps = conn.prepareStatement(query);
				ps.setString(1, toSearch);
				rs = ps.executeQuery();
				while(rs.next()) {
					List_item_data curr = new List_item_data();//create an item data object
					
					curr.setItem_bidamount(rs.getInt(""));
					curr.setItem_catagory(rs.getString(""));
					curr.setItem_currentprice(rs.getFloat(""));
					curr.setItem_description(rs.getString(""));
					curr.setItem_no(rs.getInt(""));
					curr.setItem_sellerid(rs.getInt(""));
					curr.setItem_startdate(rs.getString(""));
					curr.setItem_startprice(rs.getFloat(""));
					curr.setItem_title(rs.getString(""));
					
					item_info.add(curr);//add the object into Linked List
				}
			}
	 		catch (SQLException e1) {
	 		}
	 }
	 public ArrayList<List_item_data> getResult(){
		 return item_info;
	 }
}
