package kang.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Set_Grade")
public class Set_Grade extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Set_Grade() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String a1 = request.getParameter("a1");
		String a2 = request.getParameter("a2");
		String a3 = request.getParameter("a3");
		String a4 = request.getParameter("a4");
		String a5 = request.getParameter("a5");
		String t1 = request.getParameter("t1");
		String t2 = request.getParameter("t2");
		String t3 = request.getParameter("t3");
		String id = request.getParameter("id");

		Student e = new Student();
		e.setA1(a1);
		e.setA2(a2);
		e.setA3(a3);
		e.setA4(a4);
		e.setA5(a5);
		e.setT1(t1);
		e.setT2(t2);
		e.setT3(t3);
		e.setUnm(id);

		int status = KangDAO.setGradesById(e);

		if (status > 0) {
			out.print("<h2 style=\"color:#ffffff\">Grades is successfully updated.</h2>");
		} else {
			out.println("Sorry! unable to save record");
		}
		response.sendRedirect("View_g");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
