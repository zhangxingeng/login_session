package request_handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import data.List_item_data;

public class Global_functions {
	
	public static float calc_curr_price(int item_num, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query_maxbid = "SELECT MAX(price) FROM bids WHERE item_num = ?";
		ps = conn.prepareStatement(query_maxbid);
		ps.setInt(1, item_num);
		rs = ps.executeQuery();
		float curr_price = (float)(-1);
		if(rs.next()) {
			curr_price = rs.getFloat("MAX(price)");
		}
		String query_startprice = "SELECT start_price FROM item WHERE item_num = ?";
		ps = conn.prepareStatement(query_startprice);
		ps.setInt(1, item_num);
		rs = ps.executeQuery();
		Float start_price = (float) 0;
		if(rs.next()) {
			start_price = rs.getFloat("start_price");
			if(start_price > curr_price) {
				curr_price = start_price;
			}
		}
		return curr_price;
	}
	public static int calc_bid_num(int item_num, Connection conn) throws SQLException {
		int bid_amount = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query_bid_amount = "SELECT COUNT(*) cnt FROM bids WHERE item_num = ?";
		ps = conn.prepareStatement(query_bid_amount);
		ps.setInt(1, item_num);
		rs = ps.executeQuery();
		if(rs.next()) {
			bid_amount = rs.getInt("cnt");
		}
		return bid_amount;
	}
}
