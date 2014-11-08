package cx.studio.store.backstage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cx.studio.store.service.EvaluatesService;
import cx.studio.store.service.impl.EvaluatesServiceImpl;

public class EvaluateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		int index = url.indexOf("evaluates");
		String str = url.substring(index + 10);
		if ("index".equals(str)) {
			List<List<Object>> evaluates = getAllEvaluates();
			request.setAttribute("list", evaluates);
			request.getRequestDispatcher(
					"/WEB-INF/backstage/evaluates/index.jsp").forward(request,
					response);
		} else if ("delete".equals(str)) {
			String StrId = request.getParameter("id");
			int id = 0;
			if (StrId != null) {
				id = Integer.parseInt(StrId);
			}
			int result = delete(id);
			String aid = "";
			if (result != 1) {
				aid = "cao";
			} else {
				aid = StrId;
			}
			PrintWriter out = response.getWriter();
			out.print(aid);
		} else if ("search".equals(str)) {
			String colName = request.getParameter("colName");
			String key = request.getParameter("key");
			List<List<Object>> list = search(colName, key);
			request.setAttribute("list", list);
			request.getRequestDispatcher(
					"/WEB-INF/backstage/evaluates/index.jsp").forward(request,
					response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	EvaluatesService service = new EvaluatesServiceImpl();

	private List<List<Object>> getAllEvaluates() {
		List<List<Object>> e = service.getAllEvaluates();
		return e;
	}

	private int delete(int id) {
		return service.delete(id);
	}

	private List<List<Object>> search(String colName, String key) {
		List<List<Object>> e = service.search(colName, key);
		return e;
	}

}
