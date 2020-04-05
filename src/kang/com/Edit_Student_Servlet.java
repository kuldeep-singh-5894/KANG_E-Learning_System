package kang.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Edit_Student_Servlet")
public class Edit_Student_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Edit_Student_Servlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String course = request.getParameter("course");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		Date odob = Date.valueOf(dob);
		String ms = request.getParameter("ms");
		String email = request.getParameter("mail");
		String pn = request.getParameter("mnumber");
		String id = request.getParameter("id");
		try {

			Student s = new Student();
			s.setFname(fname);
			s.setLname(lname);
			s.setCourse(course);
			s.setGender(gender);
			s.setOdob(odob);
			s.setMs(ms);
			s.setEmail(email);
			s.setPn(pn);
			int status = KangDAO.Edit_Student(s, id);
			if (status > 0) {
				out.print("<h2 style=\"color:#ffffff\">Information is successfully updated.</h2>");

			} else {
				out.println("Sorry! unable to save record");
			}
			HttpSession session = request.getSession();
			if (session.getAttribute("id").equals("Professor")) {
				response.sendRedirect("View_s");

			} else {
				request.getRequestDispatcher("GetStudentById?id=" + id).forward(request,
						response);
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
		out.close();
	}

}
