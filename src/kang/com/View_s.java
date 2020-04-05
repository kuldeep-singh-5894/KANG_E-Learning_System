package kang.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/View_s")
public class View_s extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public View_s() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<marquee> Welcome to our KANG E-learning System</marquee>");
		out.println(
				"<body><h1 id='head'>Welcome to KANG E-learning System </br></br> <a href=professor.html> Go To Main Menu </a></h1>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/view_s.css\">");
		out.println("<form action=\"Search_s\" method=\"post\">");
		out.println("<label style='font-size:25px; font-weight: 900;'> Search by Name :</label>");
		out.println("<input style='padding: 5px;' type=\"text\" name=\"search\" value=\"\" id=\"search\" max=\"25\">");
		out.println("<input type=\"submit\" value=\"Search\" style=\" padding: 5px; cursor: pointer;\">");
		out.println("</form>");
		out.println(
				"<a href=\"View_s\"><input type=\"text\" value=\"View All Student\" style=\" padding: 5px; cursor: pointer;\"></a>");

		List<Student> list = KangDAO.getAllStudents();

		out.print("<table>");
		out.print(
				"<tr><th>Student ID</th><th>First Name</th><th>Last Name</th><th>Course</th><th>Gender</th><th>Date of Birth</th><th>Marital Status</th><th>Email</th><th>Phone_Number</th><th colspan=2>Edit/Delete</th></tr>");
		for (Student s : list) {
			out.print("<tr><td>" + s.getUnm() + "</td><td>" + s.getFname() + "</td><td>" + s.getLname() + "</td><td>"
					+ s.getCourse() + "</td><td>" + s.getGender() + "</td><td>" + s.getOdob() + "</td><td>" + s.getMs()
					+ "</td><td>" + s.getEmail() + "</td><td>" + s.getPn() + "</td><td><a href='Edit_Form?id="
					+ s.getUnm() + "'>Edit</a></td>  <td><a href='Delete_s?id=" + s.getUnm()
					+ "'>Delete</a></td></tr>");
		}
		out.print("</table></body>");
		out.print("<footer><a href='#top' class='sign_in' ><h2 id='btt'>Back to Top</h2></a>");
		out.print("<h2>E-Learning System</h2><h2>Copyright&copy;by KANG Group #5  2020</h2></footer>");
		out.close();
	}

}
