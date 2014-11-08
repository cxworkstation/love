package cx.studio.store.backstage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cx.studio.store.service.UserService;
import cx.studio.store.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		int index = url.indexOf("users");
		String str = url.substring(index + 6);
		if ("index".equals(str)) {
			List<List<Object>> users = findAllUser();
			request.setAttribute("list", users);
			request.getRequestDispatcher("/WEB-INF/backstage/users/index.jsp")
					.forward(request, response);
		} else if ("delete".equals(str)) {
			String StrId = request.getParameter("id");
			int id = Integer.parseInt(StrId);
			boolean flag = delete(id);
			String aid = "";
			if (!flag) {
				aid = "cao";
			} else {
				aid = StrId;
			}
			PrintWriter out = response.getWriter();
			out.print(aid);
		} else if ("search".equals(str)) {
			String colName = request.getParameter("colName");
			String key = request.getParameter("key");
			List<List<Object>> users = search(colName, key);
			request.setAttribute("list", users);
			request.getRequestDispatcher("/WEB-INF/backstage/users/index.jsp")
					.forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	UserService service = new UserServiceImpl();

	private List<List<Object>> search(String colName, String key) {
		List<List<Object>> users = service.search(colName, key);
		return users;
	}

	private boolean delete(int id) {
		boolean flag = false;
		int result = service.delete(id);
		if (result == 1) {
			flag = true;
		}
		return flag;
	}

	private List<List<Object>> findAllUser() {
		List<List<Object>> list = service.getAllUsers();
		return list;
	}
}
