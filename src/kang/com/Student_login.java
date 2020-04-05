package kang.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Student_login")
public class Student_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Student_login() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// dispatch the request to login.jsp resource
		String errorMessage = "Please Login Your Credentials!";
		request.setAttribute("error", errorMessage);
		request.getRequestDispatcher("s_sign_in.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Student_id = request.getParameter("id");
		String Password = request.getParameter("pswd");
		boolean isValid = KangDAO.studentValidation(Student_id, Password);

		if (isValid) {
			HttpSession session = request.getSession();
			session.setAttribute("id", Student_id);
			session.setMaxInactiveInterval(60 * 5);
			request.getRequestDispatcher("Student_Home").forward(request, response);
		} else {
			String errorMessage = "Invalid Student ID or Password, please login again!";
			request.setAttribute("error", errorMessage);
			request.getRequestDispatcher("s_sign_in.jsp").forward(request, response);
		}

	}

}
