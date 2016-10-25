package com.nci.syncengine.wsbg.service.impl;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.axis.AxisFault;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jeaw.webservice.client.ParamsMap;
import com.jeaw.webservice.client.WebServiceClientException;
import com.jeaw.webservice.http.client.CommonHttpWebServiceClient;
import com.nci.syncengine.api.service.NoticeService;
import com.nci.syncengine.util.PropUtil;
import com.nci.syncengine.wsbg.entity.WebServiceUser;

@RunWith(SpringJUnit4ClassRunner.class)
// 用于配置spring中测试的环境
@ContextConfiguration(locations = { "classpath:config/application-context.xml" })
// 用于指定配置文件所在的位置
public class WS_NoticeTest {

	private static String WSDL_ADDRESS = PropUtil
			.getProperty("service_dbsx_wsdlAddress");
	private static String SYSTEM = PropUtil.getProperty("service_dbsx_system");
	private static String USER_ID = "";
	private static String ORGANIZATION_ID = "";

	private static String WS_USERNAME = PropUtil
			.getProperty("service_dbsx_username");
	private static String WS_PASSWORD = PropUtil
			.getProperty("service_dbsx_password");

	private static NoticeService noticeService = null;

	private NoticeService getNoticeService() throws AxisFault {
		if (noticeService == null) {
			noticeService = new NoticeService(WSDL_ADDRESS, WS_USERNAME,
					WS_PASSWORD);
		}
		return noticeService;
	}

	@Test
	public void testAddNotice() throws RemoteException {
		String className = "user";
		String classId = "zhangjingren";
		String type = "wsbg";
		String taskId = UUID.randomUUID().toString();
		String title = "wsbg-title";
		String content = "content";
		String url = "url";
		getNoticeService().addNotice(className, classId, type, taskId, title,
				content, url);
	}

	@Test
	public void testCompletedNotice() throws RemoteException {
		String type = "wsbg";
		String taskId = "6e477154-c976-4eb0-8bac-edac0dccabec";
		getNoticeService().completedNotice(type, taskId);
	}

	@Test
	public void test() throws RemoteException {
		try {
			String userId = getUUMSLoginID("mamin");
			System.out.println(userId);
		} catch (WebServiceClientException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 调用公共数据平台服务，根据应用系统用户ID获得统一用户ID
	 * 
	 * @param appsysLoginId
	 *            应用系统用户ID
	 * @return 统一用户ID
	 */
	private String getUUMSLoginID(String appsysLoginId)
			throws WebServiceClientException {
		String wsdl = PropUtil.getProperty("service_usermap_wsdlAddress");
		String username = PropUtil.getProperty("service_usermap_username");
		String password = PropUtil.getProperty("service_usermap_password");
		CommonHttpWebServiceClient client = new CommonHttpWebServiceClient(
				wsdl, username, password);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("PAGE", "1");
		map.put("PAGESIZE ", "1");
		map.put("APPSYSLOGINID", appsysLoginId);
		map.put("APPSYSCODE", "WSBG");
		ParamsMap params = new ParamsMap();
		params.addParam(map);
		params.setResultType(ParamsMap.RETURNTYPE_JSON);
		String result = client.query(params);
		JSONObject jsonObject = JSONObject.fromObject(result);
		if ("DAS00000".equals(jsonObject.get("code"))) {
			JSONArray jsonArray = JSONArray.fromObject(jsonObject.get("datas"));
			List<Map<String, Object>> mapList = (List) jsonArray;
			//应用系统用户ID和统一用户ID是1对1关系，所以正常情况下只能查到一条数据
			if (mapList.size() == 1) {
				return (String) mapList.get(0).get("UUMSLOGINID");
			}
		}
		return null;
	}

}
