package request_handler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.DBConnect;

@WebServlet("/Removeauction_handler")
public class Removeauction_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Removeauction_handler() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        int item_num =Integer.parseInt(request.getParameter("item_num"));
		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		PreparedStatement ps = null;
		
		try {
			String deleteAuction = "DELETE FROM item where item_num =?";
			ps = conn.prepareStatement(deleteAuction);
			ps.setInt(1,item_num);
			ps.executeUpdate();
			
		}catch(SQLException e) {}
		finally {
			try {
				if(conn != null) {conn.close();}
			} catch (SQLException e) {}
		}
	
	}
}
