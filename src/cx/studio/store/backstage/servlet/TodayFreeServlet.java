package cx.studio.store.backstage.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cx.studio.store.model.Goods;
import cx.studio.store.service.BaseColumnService;
import cx.studio.store.service.impl.BaseColumnServiceImpl;
import cx.studio.store.utils.WebUtil;

public class TodayFreeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String StrId = request.getParameter("id");
		int id = 0;
		if (StrId != null) {
			id = Integer.parseInt(StrId);
		}
		String url = request.getRequestURI();
		int index = url.indexOf("todayfree");
		String str = url.substring(index + 10);
		if ("index".equals(str)) {
			List<List<Object>> list = getAllCurrent();
			request.setAttribute("list", list);
			request.getRequestDispatcher(
					"/WEB-INF/backstage/todayfree/index.jsp").forward(request,
					response);
		} else if ("addInput".equals(str)) {
			request.getRequestDispatcher(
					"/WEB-INF/backstage/todayfree/addInput.jsp").forward(
					request, response);
		} else if ("remarkInput".equals(str)) {
			request.setAttribute("aid", id);
			request.setAttribute("remark", getRemark(id));
			request.getRequestDispatcher(
					"/WEB-INF/backstage/todayfree/remarkInput.jsp").forward(
					request, response);
		} else if ("delBatch".equals(str)) {

		} else if ("updateInput".equals(str)) {
			List<List<Object>> good = getById(id);
			List<Object> list = good.get(0);
			request.setAttribute("list", list);
			request.getRequestDispatcher(
					"/WEB-INF/backstage/todayfree/updateInput.jsp").forward(
					request, response);
		} else if ("delete".equals(str)) {
			boolean flag = delete(id);
			if (flag) {
				request.getRequestDispatcher(
						"/WEB-INF/backstage/common/success.jsp").forward(
						request, response);
			} else {
				request.getRequestDispatcher(
						"/WEB-INF/backstage/common/fail.jsp").forward(request,
						response);
			}
		} else if ("update".equals(str)) {
			boolean flag = update();
			if (flag) {
				request.getRequestDispatcher(
						"/WEB-INF/backstage/common/success.jsp").forward(
						request, response);
			} else {
				request.getRequestDispatcher(
						"/WEB-INF/backstage/common/fail.jsp").forward(request,
						response);
			}
		} else if ("updateremark".equals(str)) {
			boolean flag = false;
			String remark = request.getParameter("remark");
			int aid = Integer.parseInt(request.getParameter("aid"));
			flag = updateremark(remark, aid);
			if (flag) {
				request.getRequestDispatcher(
						"/WEB-INF/backstage/common/success.jsp").forward(
						request, response);
			} else {
				request.getRequestDispatcher(
						"/WEB-INF/backstage/common/fail.jsp").forward(request,
						response);
			}
		} else if ("add".equals(str)) {
			Goods goods = WebUtil.request2Bean(request, Goods.class);
			boolean flag = addCurrent(goods);
			if (flag) {
				request.getRequestDispatcher(
						"/WEB-INF/backstage/common/success.jsp").forward(
						request, response);
			} else {
				request.getRequestDispatcher(
						"/WEB-INF/backstage/common/fail.jsp").forward(request,
						response);
			}
		} else if ("search".equals(str)) {
			String colName = request.getParameter("colName");
			String key = request.getParameter("key");
			List<List<Object>> list = search(colName, key);
			request.setAttribute("list", list);
			request.getRequestDispatcher(
					"/WEB-INF/backstage/todayfree/index.jsp").forward(request,
					response);

		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	BaseColumnService service = new BaseColumnServiceImpl();

	// 修改
	private boolean update() {
		return true;
	}

	// 条件查询
	private List<List<Object>> search(String colName, String key) {
		List<List<Object>> list = service.search(colName, key);
		return list;
	}

	// 根据id查看
	private List<List<Object>> getById(int id) {
		List<List<Object>> goods = service.getById(id);
		return goods;
	}

	// 查看所有
	private List<List<Object>> getAllCurrent() {
		List<List<Object>> goods = service.findAllCurrent("c2");// c1默认就是当季推荐(类里面可以改名字)
		System.out.println(goods);
		return goods;
	}

	// 删除（根据id)
	private boolean delete(int id) {
		boolean flag = service.deleteCurrentById(id, "c2");
		return flag;
	}

	// 添加商品
	private boolean addCurrent(Goods goods) {
		boolean flag = false;
		flag = service.addCurrent(goods, "c2");
		return flag;
	}

	// 查看备注
	public String getRemark(int id) {
		String remark = service.getRemark(id);
		return remark;
	}

	// 修改备注
	public boolean updateremark(String remark, int id) {
		boolean flag = false;
		int result = service.updateRemark(remark, id);
		if (result == 1) {
			flag = true;
		}
		return flag;
	}
}