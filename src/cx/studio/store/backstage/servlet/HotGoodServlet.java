package cx.studio.store.backstage.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cx.studio.store.service.HotGoodService;
import cx.studio.store.service.impl.HotGoodServiceImpl;

public class HotGoodServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		int index = url.indexOf("hotgood");
		String str = url.substring(index + 8);
		if ("index".equals(str)) {
			List<List<Object>> list = getAllHotGoods();
			request.setAttribute("list", list);
			request
					.getRequestDispatcher(
							"/WEB-INF/backstage/hotgood/index.jsp").forward(
							request, response);
		} else if ("search".equals(str)) {
			String colName = request.getParameter("colName");
			String key = request.getParameter("key");
			List<List<Object>> list = getTrueGood(colName, key);
			request.setAttribute("list", list);
			request
					.getRequestDispatcher(
							"/WEB-INF/backstage/hotgood/index.jsp").forward(
							request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	HotGoodService service = new HotGoodServiceImpl();

	// 榜单前十
	private List<List<Object>> getAllHotGoods() {
		List<List<Object>> list = service.getAllHotGood(50);
		return list;
	}

	private List<List<Object>> getTrueGood(String colName, String key) {
		List<List<Object>> list = service.getTrueGood(colName, key);
		return list;
	}

}
