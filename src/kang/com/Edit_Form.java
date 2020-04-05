package kang.com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Edit_Form")
public class Edit_Form extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Edit_Form() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		Student s = KangDAO.getStudentsById(id);
		out.println("<marquee> Welcome to our KANG E-learning System</marquee>");
		out.println("<body><h1 id='head'>Student Information Editing Form</h1>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/s_sign_up.css\">");
		out.println(
				"<div class='sub_form'><h2>Please fill the information for updating Account Information</h2><span>* All fields are required.</span><br><br><form action='Edit_Student_Servlet?id="
						+ id + "' method='post'><div id='tname'>");
		out.println(
				"<table><tr><td><label> First Name* :</label></td><td><label> Last Name* :</label></td>	</tr><tr><td><input type='text' name='fname' id='fname' value='"
						+ s.getFname()
						+ "' class=\"name\" max=\"25\" placeholder=\"Enter your first name\"  required>");
		out.println("</td><td><input type=\"text\" name=\"lname\" value='" + s.getLname()
				+ "'id=\"lname\" class=\"name\" max=\"25\" placeholder=\"Enter your last name\" required></td></tr></table><br><table><tr><td><label>Course* :</label><br>");
		out.println(
				"</td></tr><tr><td><select id=\"course\" name=\"course\" required><option value=\"\">Your course is "
						+ s.getCourse()
						+ "</option><option name=\"course\" value=\"html\" >Web Development(1-HTML)</option><option name=\"course\" value=\"css\" >Web Development(2-CSS)</option>");
		out.println(
				"<option name=\"course\" value=\"js\" >Web Development(3-JavaScript)</option><option name=\"course\" value=\"javaee\" >Java EE</option><option name=\"course\" value=\"jq\" >J Query</option><option name=\"course\" value=\"cs\" >C Sharp</option><option name=\"course\" value=\"python\" >Python</option><option name=\"course\" value=\"politics\" >Politics</option></select>");
		out.println(
				"</td>	</tr></table><br></div><label> Gender* :</label><br><input type=\"radio\" name=\"gender\" id=\"gender\" value=\"Male\" selected required> Male<input type=\"radio\" name=\"gender\" id=\"gender\" value=\"Female\" required> Female<input type=\"radio\" name=\"gender\" id=\"gender\" value=\"Other\" required> Other<br><br >");
		out.println(
				"<table><tr><td><label> Date of Birth* :</label><br></td><td><label>Merital Status* :</label><br></td></tr><tr><td><input type=\"date\" value='"
						+ s.getOdob()
						+ "'name=\"dob\" id=\"dob\" max=\"2017-12-31\" min=\"1960-01-01\" required></td><td><select id=\"ms\" name=\"ms\" required>");
		out.println("<option value=\"" + s.getMs() + "\">" + s.getMs()
				+ "</option><option name=\"ms\" value=\"Single\" >Single</option><option name=\"ms\" value=\"Married\" >Married</option><option name=\"ms\" value=\"In a relationship\" >In a relationship</option><option name=\"ms\" value=\"Divorced\" >Divorced</option></select></td>	</tr></table><br><table><tr><td><label> Email* :</label></td><td>");
		out.println("<label> Phone number* :</label></td></tr><tr><td><input type=\"Email\" name=\"mail\" value='"
				+ s.getEmail()
				+ "' id=\"mail\" class=\"name\" pattern=\"[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\" placeholder=\"Enter your email address\" required></td><td><input type=\"text\" name=\"mnumber\" id=\"mnumber\" class=\"name\" value='"
				+ s.getPn()
				+ "' pattern=\"[0-9]{3}-[0-9]{3}-[0-9]{4}\" placeholder=\"Enter your phone number\" required><span class=\"note\">//Format: 123-456-7890</span></td>");
		out.println(
				"</tr></table><br></table><br><br><input type=\"submit\" class=\"sub\" value=\"Submit\"></form></div><body>\"");
		out.print("<footer><a href='#top' class='sign_in' ><h2 id='btt'>Back to Top</h2></a>");
		out.print("<h2>E-Learning System</h2><h2>Copyright&copy;by KANG Group #5  2020</h2></footer>");
		out.close();
	}

}
