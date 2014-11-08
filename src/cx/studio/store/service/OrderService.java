package cx.studio.store.service;

import java.util.List;

public interface OrderService {
	// 查找所有订单
	public List<List<Object>> findAllOrders();

	// 根据id删除订单
	public boolean delete(String orderId);

	// 条件查找
	public List<List<Object>> search(String colName, String key);
}
