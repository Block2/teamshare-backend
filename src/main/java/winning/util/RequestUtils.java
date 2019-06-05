package winning.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 公共类Common
 * 
 * <p>创建日期：2017年5月15日下午5:02:08</p>
 * @author s_xd@winning.com.cn
 */
public class RequestUtils {
	/**
	 * 获取请求的参数map 
	 *
	 * @param request
	 * @return
	 */
	public static Map<String, String> getRequestParamMap(HttpServletRequest request) {
		// 方式二：getParameterNames()：获取所有参数名称
		Enumeration<String> a = request.getParameterNames();
		String parm = null;
		String val = "";
		Map<String, String> parmMap = new HashMap<String, String>();
		while (a.hasMoreElements()) {
			// 参数名
			parm = a.nextElement();
			// 值
			val = request.getParameter(parm);
			parmMap.put(parm, val);
		}
		return parmMap;
	}

	/**
	 * 获取请求参数结果 
	 * 
	 * @param paramMap 参数集合map
	 * @param paramName 参数名称
	 * @return 字符串
	 *
	 * @author s_xd@winning.com.cn
	 * <p>创建日期：2017年6月26日下午2:13:34</p>
	 */
	public static String readRequestParam(Map<String, String> paramMap, String paramName) {
		if (paramMap == null || paramMap.size() == 0 || !paramMap.containsKey(paramName)) {
			return "";
		}
		if(paramMap.get(paramName) == null || paramMap.get(paramName).equals("")){
			return "";
		}
		return paramMap.get(paramName).trim();
	}

}
