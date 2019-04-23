package request_handler;

import java.util.*;
import java.util.Date;
import java.io.IOException;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import connect.DBConnect;
import data.Account_data;


@WebServlet("/Set_alert_handler")
public class Set_alert_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static Date addDay(Date date) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.DAY_OF_YEAR, 7);
	        return cal.getTime();
	    }
	
    public Set_alert_handler() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int item_num = (int)request.getAttribute("set_alert");
		//get email from session
		//INSERT INTO alert () VALUE(?,?)
		
		
		
	}
	
}