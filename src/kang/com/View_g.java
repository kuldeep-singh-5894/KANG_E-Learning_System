package kang.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/View_g")
public class View_g extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public View_g() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<marquee> Welcome to our KANG E-learning System</marquee>");
		out.println(
				"<body><h1 id='head'>Welcome to KANG E-learning System </br></br> <a href=professor.html> Go To Main Menu </a></h1>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/view_s.css\">");
		out.println("<form action=\"Search_g\" method=\"post\">");
		out.println("<label style='font-size:25px; font-weight: 900;'> Search by Name :</label>");
		out.println("<input style='padding: 5px;' type=\"text\" name=\"search\" value=\"\" id=\"search\" max=\"25\">");
		out.println("<input type=\"submit\" value=\"Search\" style=\" padding: 5px; cursor: pointer;\">");
		out.println("</form>");
		out.println(
				"<a href=\"View_g\"><input type=\"text\" value=\"View All Student\" style=\" padding: 5px; cursor: pointer;\"></a>");

		List<Student> list = KangDAO.getGrades();

		out.print("<table>");
		out.print(
				"<tr><th>Student ID</th><th>Name</th><th>Course</th><th>Assignment 1</th><th>Assignment 2</th><th>Assignment 3</th><th>Assignment 4</th><th>Assignment 5</th><th>Test 1</th><th>Test 2</th><th>Test 3</th><th>Grading</th></tr>");
		for (Student s : list) {
			out.print("<tr><td>" + s.getUnm() + "</td><td>" + s.getname() + "</td><td>" + s.getCourse() + "</td><td>"
					+ s.getA1() + "</td><td>" + s.getA2() + "</td><td>" + s.getA3() + "</td><td>" + s.getA4()
					+ "</td><td>" + s.getA5() + "</td><td>" + s.getT1() + "</td><td>" + s.getT2() + "</td><td>"
					+ s.getT3() + "</td><td><a href='Grade_form.jsp?id=" + s.getUnm() + "'>Update</a></td></tr>");
		}
		out.print("</table></body>");
		out.print("<footer><a href='#top' class='sign_in' ><h2 id='btt'>Back to Top</h2></a>");
		out.print("<h2>E-Learning System</h2><h2>Copyright&copy;by KANG Group #5  2020</h2></footer>");
		out.close();

	}

}
