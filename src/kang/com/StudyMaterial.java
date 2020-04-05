package kang.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudyMaterial")
public class StudyMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudyMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String id = request.getParameter("id");
		Student s = KangDAO.getCourse(id);
		String course = s.getCourse();
		switch (course) {
		case "html":
			request.getRequestDispatcher("/Student/htmlMaterial.jsp").include(request, response);
			break;
		case "css":
			request.getRequestDispatcher("/Student/cssMaterial.jsp").include(request, response);
			break;
		case "js":
			request.getRequestDispatcher("/Student/jsMaterial.jsp").include(request, response);
			break;
		case "javaee":
			request.getRequestDispatcher("/Student/javaEEMaterial.jsp").include(request, response);
			break;
		case "jq":
			request.getRequestDispatcher("/Student/jQueryMaterial.jsp").include(request, response);
			break;
		case "cs":
			request.getRequestDispatcher("/Student/cSharpMaterial.jsp").include(request, response);
			break;
		case "python":
			request.getRequestDispatcher("/Student/pythonMaterial.jsp").include(request, response);
			break;
		case "politics":
			request.getRequestDispatcher("/Student/politicsMaterial.jsp").include(request, response);
			break;
		default:
			request.getRequestDispatcher("s_sign_in.jsp").include(request, response);
			break;
		}
	}

}
