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

@WebServlet("/Removebid_handler")
public class Removebid_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Removebid_handler() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			DBConnect DBC = new DBConnect();
			Connection conn = DBC.getConn();
			PreparedStatement ps = null;

			try {
				int item_num =Integer.parseInt(request.getParameter("item_num"));
				String deleteBid = "DELETE FROM bids b WHERE b.item_num = ? ORDER BY date DESC LIMIT 1";
				ps = conn.prepareStatement(deleteBid);
				ps.setInt(1,item_num);
				ps.executeUpdate();
			response.sendRedirect("staff_home.jsp");
			}catch(SQLException e) {}
			finally {
				try {
					if(conn != null) {conn.close();}
				} catch (SQLException e) {}
			}
		}
	}
