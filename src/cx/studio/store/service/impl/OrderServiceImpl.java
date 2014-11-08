package cx.studio.store.service.impl;

import java.util.List;

import cx.studio.store.dao.OrderDao;
import cx.studio.store.dao.impl.OrderDaoImpl;
import cx.studio.store.service.OrderService;

public class OrderServiceImpl implements OrderService {
	OrderDao orderDao = new OrderDaoImpl();

	@Override
	public List<List<Object>> findAllOrders() {
		List<List<Object>> orders = orderDao.getAllOrder();
		return orders;
	}

	@Override
	public boolean delete(String orderId) {
		boolean result = orderDao.deleteOrder(orderId);
		return result;
	}

	@Override
	public List<List<Object>> search(String colName, String key) {
		List<List<Object>> orders = orderDao.search(colName, key);
		return orders;
	}

}
