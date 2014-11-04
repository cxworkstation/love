package cx.studio.store.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

public class WebUtil {

	/**
	 * 实现表单数据到JavaBean数据之间的封装
	 */
	public static <T> T request2Bean(HttpServletRequest request,
			Class<T> beanClass) {

		try {
			/** 得到要转换Bean的类型 */
			T bean = beanClass.newInstance();
			/** 获取表单参数 */
			Map map = request.getParameterMap();
			/** 注册类型转换器 */
			ConvertUtils.register(new Converter() {

				/** 实现convert方法 */
				public Object convert(Class type, Object value) {
					if (value == null) {
						return null;
					}
					String str = (String) value;
					if ("".equals(str.trim())) {
						return null;
					}
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					try {
						return sdf.parse(str);
					} catch (ParseException e) {
						throw new RuntimeException(e);
					}
				}

			}, Date.class);
			/** 构建Bean */
			BeanUtils.populate(bean, map);
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}