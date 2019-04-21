package connect;
import java.sql.*;

public class DBConnect {
	Connection connection = null;
	
	public DBConnect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://cs336.c8i9b7bbuew6.us-east-2.rds.amazonaws.com:3306/BuyMe";
			connection = DriverManager.getConnection(url,"geng", "88888888");
		}
		catch (ClassNotFoundException e) {}
		catch (SQLException e) {}
	}
	
	public Connection getConn() {
		return connection;
	}
	
	public void DBDisconnect(Connection connection){
		try {
			connection.close();
		} catch (SQLException e) {}
	}
	
	
	public static void main(String[] args) {
		DBConnect conn = new DBConnect();
		System.out.println(conn.connection);	
		conn.DBDisconnect(conn.connection);
	}
	
}
