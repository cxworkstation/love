package cx.studio.store.backstage.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		int index = url.indexOf("users");
		String str = url.substring(index + 6);
		if ("index".equals(str)) {
			request.getRequestDispatcher("WEB-INF/backstage/users/index.jsp")
					.forward(request, response);
		}
	}
}
