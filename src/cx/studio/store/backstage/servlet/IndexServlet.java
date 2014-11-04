package cx.studio.store.backstage.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url=request.getRequestURI();
		int index=url.indexOf("index");
		if(index!=-1) {
			String str=url.substring(index+6);
			if("top".equals(str)) {
				request.getRequestDispatcher("/WEB-INF/backstage/top.jsp").forward(request, response);
			}else if("menu".equals(str)) {
				request.getRequestDispatcher("/WEB-INF/backstage/menu.jsp").forward(request, response);
			}else if("main".equals(str)) {
				request.getRequestDispatcher("/WEB-INF/backstage/main.jsp").forward(request, response);
			}
		}
	}
}
