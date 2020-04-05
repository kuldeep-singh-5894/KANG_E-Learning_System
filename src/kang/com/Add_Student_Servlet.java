package kang.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Add_Student_Servlet")
public class Add_Student_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Add_Student_Servlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String unm = request.getParameter("uname");
		String pwd = request.getParameter("pswd");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String course = request.getParameter("course");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		Date odob = Date.valueOf(dob);
		String ms = request.getParameter("ms");
		String email = request.getParameter("mail");
		String pn = request.getParameter("mnumber");
		try {
			Student s = new Student(unm, pwd, fname, lname, course, gender, odob, ms, email, pn);
			int status = KangDAO.save(s);
			if (status > 0) {
				String errorMessage = "You are successfully Signed up!";
				request.setAttribute("error", errorMessage);
				request.getRequestDispatcher("s_sign_in.jsp").include(request, response);;
			} else {
				out.println("Sorry! unable to save record");
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
		out.close();
	}
}
