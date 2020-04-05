package kang.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetGradesById")
public class GetGradesById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetGradesById() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String id = request.getParameter("id");
		Student s = KangDAO.getGradesbyId(id);
		request.setAttribute("s", s);
		request.getRequestDispatcher("/Student/myGrades.jsp").include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
