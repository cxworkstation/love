package cx.studio.store.backstage.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cx.studio.store.utils.CodeUtil;

public class AddPictureServlet extends HttpServlet {
	private ServletContext sc;
	private String savePath;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			Iterator it = items.iterator();
			String newName = "";
			String imgurl = "";
			while (it.hasNext()) {
				FileItem item = (FileItem) it.next();
				if (!item.isFormField()) {
					File tempfile = new File(item.getName());
					String[] strName = tempfile.getName().split("\\.");
					int i = strName.length - 1;
					String suffix = "";
					if ("jpg".equals(strName[i])) {
						suffix = ".jpg";
					} else if ("png".equals(strName[i])) {
						suffix = ".png";
					} else if ("gif".equals(strName[i])) {
						suffix = ".gif";
					} else if ("bmp".equals(strName[i])) {
						suffix = ".bmp";
					}
					newName = CodeUtil.getPhotoName() + suffix;
					imgurl = sc.getRealPath("/") + savePath + "\\" + newName;
					File file = new File(imgurl);
					item.write(file);
				}
			}
			String saveUrl = savePath + "/" + newName;
			request.setAttribute("imgurl", saveUrl);
			request.setAttribute("newName", newName);
			request.getRequestDispatcher("/WEB-INF/backstage/test.jsp")
					.forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void init(ServletConfig config) throws ServletException {
		savePath = config.getInitParameter("savePath");
		sc = config.getServletContext();
	}

}
