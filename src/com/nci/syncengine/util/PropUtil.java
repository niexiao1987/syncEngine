package com.nci.syncengine.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtil {
	private static Properties prop;

	static {
		prop = new Properties();
		InputStream in = new PropUtil().getClass().getResourceAsStream(
				"/webservice.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据属性key获得对应的属性值
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return prop.getProperty(key).trim();
	}
}
