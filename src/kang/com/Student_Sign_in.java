package kang.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Student_Sign_in")
public class Student_Sign_in extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Student_Sign_in() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String errorMessage = "Please Login Your Credentials!";
		request.setAttribute("error", errorMessage);
		request.getRequestDispatcher("s_sign_in.jsp").forward(request, response);
	}

}
