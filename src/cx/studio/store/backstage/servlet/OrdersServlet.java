package cx.studio.store.backstage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import cx.studio.store.service.OrderService;
import cx.studio.store.service.impl.OrderServiceImpl;

public class OrdersServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		int index = url.indexOf("orders");
		String str = url.substring(index + 7);
		if ("index".equals(str)) {
			List<List<Object>> orders = findAllOrders();
			request.setAttribute("list", orders);
			request.getRequestDispatcher("/WEB-INF/backstage/orders/index.jsp")
					.forward(request, response);
		} else if ("delete".equals(str)) {
			String order_id = request.getParameter("order_id");
			boolean flag = delete(order_id);
			if (!flag) {
				order_id = "cao";
			}
			PrintWriter out = response.getWriter();
			out.print(order_id);
		} else if ("search".equals(str)) {
			String colName = request.getParameter("colName");
			String key1 = request.getParameter("key");
			String key = "1";
			if ("未付款".equals(key1)) { // 未付款---1
				key = "1";
			} else if ("未发货".equals(key1)) {
				key = "2";
			} else if ("未确认收货".equals(key1)) {
				key = "3";
			} else if ("订单完成".equals(key1)) {
				key = "4";
			}
			List<List<Object>> orders = search(colName, key);
			request.setAttribute("list", orders);
			request.getRequestDispatcher("/WEB-INF/backstage/orders/index.jsp")
					.forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	OrderService service = new OrderServiceImpl();

	private List<List<Object>> findAllOrders() {
		List<List<Object>> orders = service.findAllOrders();
		return orders;
	}

	private boolean delete(String order_id) {
		boolean flag = service.delete(order_id);
		return flag;
	}

	@Test
	public void demo() {
		List<List<Object>> s = search("order_id", "3");
		System.out.println(s);
	}

	private List<List<Object>> search(String colName, String key) {
		List<List<Object>> orders = service.search(colName, key);
		return orders;
	}
}
