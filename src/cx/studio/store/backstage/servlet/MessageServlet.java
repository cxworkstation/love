package cx.studio.store.backstage.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class MessageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 这个list相当于是从订单表里查到的记录，一条记录里面有有商品的详细信息，但是商品的详细信息使用json串表示的
		// 现在就设立一个标准，商品的那个Json字段都放在sql语句查询的最后一个字段。
		List<List<Object>> list = new ArrayList<List<Object>>();// 后台拿到的其他信息，每个条信息记录都是一个list<object>
		List<List<Object>> resultList = new ArrayList<List<Object>>();
		for (int i = 0; i < list.size(); i++) {
			List<Object> innerList = list.get(i);
			List<Object> newInnerList = new ArrayList<Object>();
			for (int j = 0; j < innerList.size() - 1; j++) {
				newInnerList.add(innerList.get(j));// 将除商品信息字段之外的所有字段存储起来
			}
			// 存储商品信息
			// String info = innerList.get(innerList.size() - 1).toString();//
			// 这个info是个Json串，我必须在这里拿到它的具体信息，因此
			String jsonStr = "{\"goodsId\":\"test1\",\"goodsName\":\"苹果\"}";// 假设这里拿到的串是这样的
			// 要将这个串转换成对象才能拿到
			// 等会去扎一个好方法把这个串转换成J送对象，现在假设已经拿到
			JSONObject jsonObj = JSONObject.fromObject(jsonStr);
			String goodsId = jsonObj.getString("goodsId");
			String goodsName = jsonObj.getString("goodsName");
			newInnerList.add(goodsId);
			newInnerList.add(goodsName);
			resultList.add(newInnerList);// 这下不跟那个一样了么？嗯嗯
		}
		list = null;
		request.setAttribute("list", resultList);
		request.getRequestDispatcher("/WEB-INF/backstage/message/index.jsp")
				.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
	}

}
