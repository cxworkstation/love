package cx.studio.store.dao.impl;

import java.util.Date;
import java.util.List;

import cx.studio.store.dao.BaseDao;
import cx.studio.store.dao.OrderDao;
import cx.studio.store.model.Orders;
import cx.studio.store.utils.CodeUtil;

public class OrderDaoImpl implements OrderDao {
	BaseDao baseDao = new BaseDaoImpl();

	public void demo1() {
		// 添加订单
		Orders order = new Orders();
		order.setOrder_id(CodeUtil.getOrderId());
		order.setAddress("adabsaj");
		order.setPayment_method("1");
		order.setBooktime(new Date());
		order.setExpense("1.0");
		order.setDistance("11000");
		order.setProduct_id("fd2");
		order.setState(1);
		addOrder(order);
	}

	// 添加订单
	public int addOrder(Orders order) {
		String sql = "insert into orders values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] param = { null, order.getOrder_id(), order.getNumber(),
				order.getProduct_id(), order.getAddress(),
				order.getTelephone(), order.getState(), order.getBooktime(),
				order.getPayment_method(), order.getDistance(),
				order.getExpense(), order.getTotalmoney() };
		int result = baseDao.BaseUpdate(sql, param);
		return result;
	}

	public void demo2() {
		// 删除订单
		int id = 1;
		System.out.println(deleteOrder(id));
	}

	// 删除订单
	public int deleteOrder(int id) {
		String sql = "delete from orders where id=?";
		Object[] param = { id };
		int result = baseDao.BaseUpdate(sql, param);
		return result;
	}

	public void demo3() {
		// 批量删除订单
		String[] ids = { "2", "3" };
		boolean s = DelBatchOrder(ids);
		System.out.println(s);
	}

	// 批量删除订单
	public boolean DelBatchOrder(String[] ids) {
		String sql = "delete from orders where id=?";
		boolean result = baseDao.DelBatch(sql, ids);
		return result;
	}

	public void demo4() {
		// 查出所有订单
		List<List<Object>> orders = getAllOrder();
		System.out.println(orders);
	}

	// 查出所有订单
	public List<List<Object>> getAllOrder() {
		String sql = "select * from orders";
		List<List<Object>> orders = baseDao.BaseQuery(sql, null);
		return orders;
	}

	public void demo5() {
		// 根据订单状态查询订单
		int state = 1;
		List<List<Object>> orders = checkOrderState(state);
		System.out.println(orders);
	}

	// 根据订单状态查询订单
	public List<List<Object>> checkOrderState(int state) {
		String sql = "select * from orders where state=?";
		Object[] param = { state };
		List<List<Object>> orders = baseDao.BaseQuery(sql, param);
		return orders;
	}

	public void demo6() {
		// 根据订单号查询订单
		String order_id = "cmd9082500";
		List<List<Object>> orders = SearchByOrderId(order_id);
		System.out.println(orders);
	}

	// 根据订单号查询订单
	public List<List<Object>> SearchByOrderId(String orderId) {
		String sql = "select * from orders where order_id=?";
		Object[] param = { orderId };
		List<List<Object>> orders = baseDao.BaseQuery(sql, param);
		return orders;
	}

}
