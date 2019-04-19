package request_handler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register_handler
 * @param <String>
 */
@WebServlet("/Register_handler")
public class Register_handler<String> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register_handler() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		UserDao uDao=new UserDao();
		User user = null;
		try {
			user = uDao.findByName(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(user.getName());
		 System.out.println("Determine if the username is duplicated");
		if(name.equals(user.getName())){
			String msg=name+"This name already have it, change it!";
			request.setAttribute("msg", msg);
			request.sendRedirect("register.jsp").forward(request, response);
		}else{
			System.out.println("saved！");
			User user1=new User();
			user1.setName(name);
			user1.setPassword(pwd);
			try {
				uDao.saveUser(user1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String msg=name+"Already registered, please log in again.";
			request.setAttribute("msg", msg);
			request.sendRedirect("index.jsp").forward(request, response);
		}
	}}
