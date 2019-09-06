package request_handler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connect.DBConnect;
import data.List_item_data;
public class helpfunction {
	private float calc_curr_price(int item_num, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT MAX(price) FROM bids WHERE item_num = ?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, item_num);
		rs = ps.executeQuery();
		float curr_price = rs.getFloat("price");
		return curr_price;
	}
}
