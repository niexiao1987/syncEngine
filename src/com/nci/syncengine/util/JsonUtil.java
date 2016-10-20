package com.nci.syncengine.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONObject;

public class JsonUtil {
	
	public static Map toMap(String jsonString){
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		Map result = new HashMap();
		Iterator iterator = jsonObject.keys();
		String key = null;
		String value = null;
		while(iterator.hasNext()){
			key = (String)iterator.next();
			value = jsonObject.getString(key);
			result.put(key, value);
		}
		return result;
	}
	
	public static Object mapToBean(Object javaBean,Map data){
		Method[] methods = javaBean.getClass().getDeclaredMethods();
		
		for(Method method : methods){
			try{
				if(method.getName().startsWith("set")){
					String field = method.getName();
					field = field.substring(field.indexOf("set")+3);
					field = field.toLowerCase().charAt(0) + field.substring(1);
					method.invoke(javaBean, new Object[]{data.get(field)});
				}
			}catch(Exception e){
				
			}
		}
		return javaBean;
	}
	
	public static void toJavaBean(Object javaBean, String jsonString){
		Map map = toMap(jsonString);
		mapToBean(javaBean, map);
	}
}
