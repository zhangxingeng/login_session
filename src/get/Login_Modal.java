package get;
import java.sql.*;

import connect.DBConnect;
import data.Login_data;

public class Login_Modal {
	public boolean checkUserName(Login_data loginfo) {
		boolean flag = false;
		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM users WHERE email=? AND password=?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, loginfo.getUsername());
			ps.setString(2, loginfo.getPassword());
			rs = ps.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
}
