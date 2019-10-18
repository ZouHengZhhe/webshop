package web07_learn_something;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class TestBeanUtils {
	public static void main(String[] args) throws Exception {
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("username", "siki");
		map.put("email", "xxx@sikiedu.com");
		map.put("password", "123");
		
		User u = new User();
		System.out.println(u);
		BeanUtils.copyProperties(u, map);
		System.out.println(u);
	}
}
