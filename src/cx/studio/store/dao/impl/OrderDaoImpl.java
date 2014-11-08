package cx.studio.store.dao.impl;

import java.util.List;

import cx.studio.store.dao.BaseDao;
import cx.studio.store.dao.OrderDao;
import cx.studio.store.model.Ordersitem;

public class OrderDaoImpl implements OrderDao {
	BaseDao baseDao = new BaseDaoImpl();

	@Override
	public boolean DelBatchOrder(String[] ids) {
		// TODO Auto-generated method stub
		return false;
	}

	// 条件查找
	public List<List<Object>> search(String colName, String key) {
		String sql = "select orders.order_id,ordersitem.username, orders.product_name,orders.number,orders.money,ordersitem.totalmoney,ordersitem.booktime,ordersitem.address,ordersitem.telephone from orders,ordersitem where ordersitem.order_id=orders.order_id";
		if ("order_id".equals(colName)) {
			sql = "select orders.order_id,ordersitem.username, orders.product_name,orders.number,orders.money,ordersitem.totalmoney,ordersitem.booktime,ordersitem.address,ordersitem.telephone from orders,ordersitem where ordersitem.order_id=orders.order_id and orders.order_id=?";
		} else if ("state".equals(colName)) {
			sql = "select orders.order_id,ordersitem.username, orders.product_name,orders.number,orders.money,ordersitem.totalmoney,ordersitem.booktime,ordersitem.address,ordersitem.telephone from orders,ordersitem where ordersitem.order_id=orders.order_id and state=?";
		}
		Object[] param = { key };
		List<List<Object>> orders = baseDao.BaseQuery(sql, param);
		return orders;
	}

	@Override
	public int addOrder(Ordersitem order) {
		// id,订单号，订单产品名称，数量，单价，总价，下单时间，送货地址，收货人，收货电话,订单状态
		return 0;
	}

	@Override
	public boolean deleteOrder(String order_id) {
		String sql1 = "delete from orders where order_id=?";
		String sql2 = "delete from ordersitem where order_id=?";
		Object[] param = { order_id };
		boolean result = baseDao.BaseUpdate(sql1, sql2, param, param);
		return result;
	}

	public void demo1() {
		// 查找所有订单
		List<List<Object>> orders = getAllOrder();
		System.out.println(orders);
	}

	// 查找所有订单
	public List<List<Object>> getAllOrder() {
		// 订单号，订单产品名称，数量，单价，总价，下单时间，送货地址，收货人，收货电话,订单状态
		String sql = "select orders.order_id,ordersitem.username, orders.product_name,orders.number,orders.money,ordersitem.totalmoney,ordersitem.booktime,ordersitem.address,ordersitem.telephone from orders,ordersitem where ordersitem.order_id=orders.order_id";
		List<List<Object>> orders = baseDao.BaseQuery(sql, null);
		return orders;
	}

}
