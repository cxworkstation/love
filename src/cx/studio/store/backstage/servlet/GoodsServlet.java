package cx.studio.store.backstage.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cx.studio.store.model.Goods;
import cx.studio.store.service.GoodsService;
import cx.studio.store.service.impl.GoodsServiceImpl;
import cx.studio.store.utils.PageModel;
import cx.studio.store.utils.WebUtil;

public class GoodsServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String StrId = request.getParameter("id");
		int id = 0;
		if (StrId != null) {
			id = Integer.parseInt(StrId);
		}
		String url = request.getRequestURI();
		int index = url.indexOf("goods");
		String str = url.substring(index + 6);
		if ("index".equals(str)) {
			int offSet = 0;
			String offSetStr = request.getParameter("pager.offset");// 框架默认参数，表示当前页的第一条记录
			if (offSetStr != null) {
				offSet = Integer.parseInt(offSetStr);
			}
			PageModel pm = new PageModel();// 默认为pageSize=20页
			List<List<Object>> goods = getAllGoods(offSet, pm.getPageSize());
			pm.setList(goods);
			pm.setTotalCount(getCount());
			request.setAttribute("pm", pm);
			request.getRequestDispatcher("/WEB-INF/backstage/goods/index.jsp")
					.forward(request, response);
		} else if ("addInput".equals(str)) {
			request.getRequestDispatcher(
					"/WEB-INF/backstage/goods/addInput.jsp").forward(request,
					response);
		} else if ("remarkInput".equals(str)) {
			request.setAttribute("aid", id);
			request.setAttribute("remark", getRemark(id));
			request.getRequestDispatcher(
					"/WEB-INF/backstage/goods/remarkInput.jsp").forward(
					request, response);
		} else if ("delBatch".equals(str)) {
			String[] ids = request.getParameterValues("ids");
			boolean flag = delBatch(ids);
			if (flag) {
				request.getRequestDispatcher(
						"/WEB-INF/backstage/common/success.jsp").forward(
						request, response);
			} else {
				request.getRequestDispatcher(
						"/WEB-INF/backstage/common/fail.jsp").forward(request,
						response);
			}
		} else if ("updateInput".equals(str)) {
			List<List<Object>> good = getById(id);
			List<Object> list = good.get(0);
			request.setAttribute("list", list);
			request.getRequestDispatcher(
					"/WEB-INF/backstage/goods/updateInput.jsp").forward(
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
			Goods goods = WebUtil.request2Bean(request, Goods.class);
			boolean flag = update(goods);
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
			boolean flag = addGoods(goods);
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
			int offSet = 0;
			String offSetStr = request.getParameter("pager.offset");
			if (offSetStr != null) {
				offSet = Integer.parseInt(offSetStr);
			}
			PageModel pm = new PageModel();
			key = URLDecoder.decode(key, "UTF-8");
			System.out.println(key);
			List<List<Object>> list = search(colName, key, offSet, pm
					.getPageSize());
			pm.setList(list);
			pm.setTotalCount(getSearchCount(colName, key));
			request.setAttribute("pm", pm);
			request.setAttribute("colName", colName);
			request.setAttribute("key", URLEncoder.encode(key, "UTF-8"));
			request.getRequestDispatcher("/WEB-INF/backstage/goods/search.jsp")
					.forward(request, response);

		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	GoodsService service = new GoodsServiceImpl();

	// 得到整张表的记录数
	private Long getCount() {
		return service.getCount();
	}

	// 查询条件下的记录条数
	private Long getSearchCount(String colName, String key) {
		return service.getSearchCount(colName, key);
	}

	// 条件查询
	private List<List<Object>> search(String colName, String key, int offSet,
			int pageSize) {
		List<List<Object>> list = service
				.search(colName, key, offSet, pageSize);
		return list;
	}

	// 修改
	private boolean update(Goods goods) {
		boolean flag = false;
		int result = service.updateGoods(goods);
		if (result == 1) {
			flag = true;
		}
		return flag;
	}

	// 批量删除
	private boolean delBatch(String[] ids) {
		return service.DelBatch(ids);
	}

	// 根据id查看
	private List<List<Object>> getById(int id) {
		List<List<Object>> goods = service.getById(id);
		return goods;
	}

	// 查看所有
	private List<List<Object>> getAllGoods(int offSet, int pageSize) {
		List<List<Object>> goods = service.findAllGoods(offSet, pageSize);
		return goods;
	}

	// 删除（根据id)
	private boolean delete(int id) {
		int result = service.deleteGoodsById(id);
		boolean flag = false;
		if (result == 1) {
			flag = true;
		}
		return flag;
	}

	// 添加商品
	private boolean addGoods(Goods goods) {
		boolean flag = false;
		int a = service.addGoods(goods);
		if (a == 1) {
			flag = true;
		}
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
