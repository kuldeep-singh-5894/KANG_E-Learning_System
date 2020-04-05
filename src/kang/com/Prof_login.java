package kang.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Prof_login")
public class Prof_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String userID = "Professor";
	private final String password = "Admin";

	public Prof_login() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("uname");
		String pwd = request.getParameter("pswd");

		if (userID.equals(user) && password.equals(pwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("id", user);
			session.setMaxInactiveInterval(60 * 5);
			response.sendRedirect("professor.html");

		} else {
			
			String errorMessage = "Invalid ID or Password, please login again!";
			request.setAttribute("error", errorMessage);
			request.getRequestDispatcher("p_sign_in.jsp").forward(request, response);
		}
	}

}
