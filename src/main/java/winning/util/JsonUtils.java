package winning.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * Map工具类
 * 
 * <p>创建日期：2017年7月1日下午8:28:57</p>
 * @author s_xd@winning.com.cn
 */
public class JsonUtils {
	/**
	 * 将jsonArray格式的字符串转换为List<Map<String, Object>>
	 *
	 * @param jsonArrayStr 字符串格式的json数组
	 * @return
	 *
	 * @author s_xd@winning.com.cn
	 * <p>创建日期：2017年7月10日下午1:50:19</p>
	 */
    public static List<Map<String, Object>> jsonStrToListMap(String jsonArrayStr){
    	if(isEmpty(jsonArrayStr)){
    		return null;
    	}
    	List<Map<String, Object>> listMap = JSON.parseObject(jsonArrayStr,new TypeReference<List<Map<String,Object>>>(){});
    	return listMap;
    }
    
    /**
	 * 将json格式的字符串转换为Map<String, Object>
	 *
	 * @param jsonStr 字符串格式的json数据
	 * @return
	 *
	 * @author s_xd@winning.com.cn
	 * <p>创建日期：2017年7月10日下午1:50:19</p>
	 */
    public static Map<String, Object> jsonStrToMap(String jsonStr){
    	if(isEmpty(jsonStr)){
    		return null;
    	}
    	
    	Map<String, Object> map = JSON.parseObject(jsonStr,new TypeReference<Map<String,Object>>(){});
    	return map;
    }
    
    /**
     * 将json格式的字符串转换为javaBean
	 *
	 * @param jsonStr 字符串格式的json数据
     * @param clazz 如Lis_List_Mdl.Class
     * @return
     *
     * @author s_xd@winning.com.cn
     * <p>创建日期：2017年7月10日下午2:37:34</p>
     */
    public static <T> T jsonStrToBean(String jsonStr,Class<T> clazz){
    	if(isEmpty(jsonStr)){
    		return null;
    	}
    	T enti = JSON.parseObject(jsonStr,clazz);
    	return enti;
    }
    
    /**
     * 将json格式的字符串转换为List<javaBean>
     *
     * @param jsonArrayStr json数组合适的字符串
     * @param clazz 如Lis_List_Mdl.Class
     * @return
     * @
     *
     * @author s_xd@winning.com.cn
     * <p>创建日期：2017年7月10日下午2:36:39</p>
     */
    public static <T> List<T> jsonStrToListBean(String jsonArrayStr,Class<T> clazz){
    	if(isEmpty(jsonArrayStr)){
    		return null;
    	}
    	List<T> listEnti = JSON.parseArray(jsonArrayStr,clazz);
    	return listEnti;
    }


    //将对象中的属性为null的值转为空字符串
	public static Object checkNull(Object obj) {
		Class<? extends Object> clazz = obj.getClass();
		// 获取实体类的所有属性，返回Field数组
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			// 可访问私有变量
			field.setAccessible(true);
			// 获取属性类型
			String type = field.getGenericType().toString();
			// 如果type是类类型，则前面包含"class "，后面跟类名
			if ("class java.lang.String".equals(type)) {
				// 将属性的首字母大写
				String methodName = field.getName().replaceFirst(field.getName().substring(0, 1),
						field.getName().substring(0, 1).toUpperCase());
//				System.out.println(methodName);
				try {
					Method methodGet = clazz.getMethod("get" + methodName);
					// 调用getter方法获取属性值
					String str = (String) methodGet.invoke(obj);
					if (str == null || "".equals(str.trim())) {
						// Method methodSet = clazz.getMethod("set" +
						// methodName, new Class[] { String.class });
						// methodSet.invoke(o, new Object[] { "" });
//						System.out.println(field.getType()); // class java.lang.String
						// 如果为null的String类型的属性则重新复制为空字符串
						field.set(obj, field.getType().getConstructor(field.getType()).newInstance(""));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return obj;
	}

	public static boolean isEmpty(String str){
    	return str ==  null || "".equals(str.trim());
	}

}