package cx.studio.store.dao;

import java.util.List;

import cx.studio.store.model.Ordersitem;

public interface OrderDao {
	// 添加订单
	public int addOrder(Ordersitem order);

	// 删除订单
	public boolean deleteOrder(String id);

	// 批量删除订单
	public boolean DelBatchOrder(String[] ids);

	// 查看所有订单
	public List<List<Object>> getAllOrder();

	// 条件查找
	public List<List<Object>> search(String colName, String key);

	// 订单修改功能。。。
}
