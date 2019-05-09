package request_handler;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import connect.DBConnect;
import data.List_item_data;

@WebServlet("/Item_detail_handler")
public class Item_detail_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Item_detail_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		DBConnect DBC = new DBConnect();
		Connection conn = DBC.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		int item_num = Integer.parseInt(request.getParameter("item_num"));
		ArrayList<List_item_data> search_result = (ArrayList<List_item_data>)session.getAttribute("item_num");
		while(!search_result.isEmpty()){
			List_item_data curr_item = (List_item_data)search_result.remove(0);
			
		}
	}
}
