package request_handler;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import connect.DBConnect;
import data.List_item_data;
import request_handler.Global_functions;

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

		int item_num = Integer.parseInt(request.getParameter("item_num"));
		if(session.getAttribute("search_result") != null) {
			ArrayList<List_item_data> search_result = (ArrayList<List_item_data>) session.getAttribute("search_result");
			Iterator<List_item_data> i = search_result.iterator();
			List_item_data current_item = null;
			while(i.hasNext()) {
				current_item = i.next();
				if(item_num == current_item.getItem_num()) {
					
					try {
						current_item.setBid_count(Global_functions.calc_bid_num(item_num,conn));
						current_item.setCurr_price(Global_functions.calc_curr_price(item_num, conn));
					} catch (SQLException e) {}
					session.setAttribute("current_item", current_item);
					response.sendRedirect("item_page.jsp");
					return;
				}
			}
		}else {
			session.setAttribute("message", "this item does not exist.");
			response.sendRedirect("item_page.jsp");
		}
		return;
	}
}
