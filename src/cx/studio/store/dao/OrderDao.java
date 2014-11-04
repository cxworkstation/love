package cx.studio.store.dao;

import java.util.List;

import cx.studio.store.model.Orders;

public interface OrderDao {
	// 添加订单
	public int addOrder(Orders order);

	// 删除订单
	public int deleteOrder(int id);

	// 批量删除订单
	public boolean DelBatchOrder(String[] ids);

	// 查看所有订单
	public List<List<Object>> getAllOrder();

	// 根据订单号查询订单
	public List<List<Object>> SearchByOrderId(String orderId);

	// 查询订单状态（1.未付款,2.付款-未发货,3.发货-未确认收货,4.确认收货）----前台多选
	public List<List<Object>> checkOrderState(int state);
	// 订单修改功能。。。
}
