package kang.com;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class St_filter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpSession session = request.getSession();
		if (request.getRequestURI().startsWith("/E_Learning_System_KANG/Student_Home")
				|| request.getRequestURI().startsWith("/E_Learning_System_KANG/StudyMaterial")
				|| request.getRequestURI().startsWith("/E_Learning_System_KANG/GetStudentById")
				|| request.getRequestURI().startsWith("/E_Learning_System_KANG/GetGradesById")
				|| request.getRequestURI().startsWith("/E_Learning_System_KANG/Edit_Form")
				|| request.getRequestURI().startsWith("/E_Learning_System_KANG/Student_Sign_in")) {

			if (session.getAttribute("id") == null) {

				String errorMessage = "Please Login Your Credentials!";
				request.setAttribute("error", errorMessage);
				request.getRequestDispatcher("s_sign_in.jsp").forward(request, arg1);
			}
		} else if (request.getRequestURI().startsWith("/E_Learning_System_KANG/Edit_Student_Servlet")
				|| request.getRequestURI().startsWith("/E_Learning_System_KANG/Search_g")
				|| request.getRequestURI().startsWith("/E_Learning_System_KANG/Search_s")
				|| request.getRequestURI().startsWith("/E_Learning_System_KANG/Set_Grade")
				|| request.getRequestURI().startsWith("/E_Learning_System_KANG/View_g")
				|| request.getRequestURI().startsWith("/E_Learning_System_KANG/professor.html")
				|| request.getRequestURI().startsWith("/E_Learning_System_KANG/Grade_form.jsp")
				|| request.getRequestURI().startsWith("/E_Learning_System_KANG/View_s")) {

			if (session.getAttribute("id") == null) {

				String errorMessage = "Please Login Your Credentials!";
				request.setAttribute("error", errorMessage);
				request.getRequestDispatcher("p_sign_in.jsp").forward(request, arg1);
			}
		}
		arg2.doFilter(request, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
