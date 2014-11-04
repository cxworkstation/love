package cx.studio.store.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 * 现在就相当于我要跳到后台首页，点击菜单栏嘛，这个servlet就是跳到后台首页的，然后只要将菜单栏地址改一下就行了 告诉快捷键 经常用到的
	 * 知道么？不知道我根基说过 说过忘了 两个快捷键一定不能忘 因为公司的项目特别大文件很难找 另方面另一方面也说明命名很重要。。。
	 * ctrl+shift+R ctrl+H
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/backstage/index.jsp").forward(
				request, response);
	}
}
