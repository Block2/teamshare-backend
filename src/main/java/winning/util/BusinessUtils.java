package winning.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xwf on 2019/6/4.
 */
public class BusinessUtils {

    /**
     *处理过程：通过反射取bean的字段列表，每次读取一个字段内容时，先做filter处理，再接着做replaceProp和remendValue处理
     *使用注意：
     *        1、所有Map中的Key都要大写
     *
     * @param bean
     * @param filter            需要过滤掉的bean中的属性字段
     * @param replacePropMap    需要代替的属性名称映射 eg：bean中的字段filedname为sum，对应数据库表列名为summary，
     *                          则需要将<"SUM","SUMMARY">这个键值对放到replacePropMap中
     * @param remendValueMap    不使用bean提供的字段值，使用自定义的值 eg:bean中的字段filedname为sum，
     *                          则需要将<"SUM",自定义的值>这个键值对放到remendMap中
     * @Param additionMap       附加列的键值对
     * @return
     */

    public static Map<String, Object> convertBeanToMap(Object bean)
            throws IntrospectionException, InvocationTargetException, IllegalAccessException {

        Class<? extends Object> type = bean.getClass();
        Map<String, Object> map = new HashMap<String, Object>();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class")) {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(bean, new Object[0]);
                map.put(propertyName.toUpperCase(), result == null ? "" : result);
            }
        }

        return map;
    }
}
