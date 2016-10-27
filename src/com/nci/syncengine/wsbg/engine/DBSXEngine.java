package com.nci.syncengine.wsbg.engine;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.axis.AxisFault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jeaw.webservice.client.ParamsMap;
import com.jeaw.webservice.client.WebServiceClientException;
import com.jeaw.webservice.http.client.CommonHttpWebServiceClient;
import com.nci.syncengine.api.service.NoticeService;
import com.nci.syncengine.util.PropUtil;
import com.nci.syncengine.wsbg.entity.DBZHJC_DBSX;
import com.nci.syncengine.wsbg.entity.SFSQ_YHZH;

/**
 * 网上办公待办事项引擎
 * 
 * @author Danny
 *
 */
@Component
public class DBSXEngine {

	/**
	 * 添加待办事项
	 * 
	 * @param dbsx
	 *            待办事项实体
	 */
	public void addNotice(DBZHJC_DBSX dbsx) throws AxisFault, RemoteException,
			WebServiceClientException {
		// 根据待办事项类型决定发送受众,待办显示类型(0：按人员编号显示 1：按权限显示) null视为0
		// 实际情况为绝大多数都是以用户为受众，极个别以权限发布的待办事项需要转换成受众为拥有指定权限的用户
		// 所有className默认为User

		List<String> appsysLoginIds = new ArrayList<String>();
		appsysLoginIds.clear();

		if (dbsx.getSFCL() == "1") {
			// todo:根据权限获取拥有值定权限的用户，然后根据用户Id获得LoginId，最后加到appsysLoginIds中
		} else {
			SFSQ_YHZH yhzh = yhzhService.getByYHBH(dbsx.getSJRID());
			if (yhzh != null) {
				String appsysLoginId = yhzh.getYHZH();// 根据用户Id获得LoginId
				appsysLoginIds.add(appsysLoginId);
			}
		}
		for (String appsysLoginId : appsysLoginIds) {
			String classId = getUUMSLoginID(appsysLoginId);// 调用公共数据平台接口，获得对应的UUMSLoginID
			if (classId != null) {
				getNoticeService().addNotice("user", classId, SYSTEM,
						dbsx.getID(), dbsx.getBT(), null, getUrl(dbsx));
			} else {
				System.out.println("公共数据平台上没有appsysLoginId为[" + appsysLoginId
						+ "]的用户映射");
			}
		}
	}

	/**
	 * 完成待办事项
	 * 
	 * @param dbsx
	 *            待办事项实体
	 */
	public void completedNotice(String dbsxId) throws AxisFault,
			RemoteException {
		getNoticeService().completedNotice(SYSTEM, dbsxId);
	}

	private String getUrl(DBZHJC_DBSX dbsx) {
		// 根据待办事项类型获取跳转地址
		return DBSX_ADDRESS + dbsx.getSPLXBH();
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
			// 应用系统用户ID和统一用户ID是1对1关系，所以正常情况下只能查到一条数据
			if (mapList.size() == 1) {
				return (String) mapList.get(0).get("UUMSLOGINID");
			}
		}
		return null;
	}

	@Autowired
	private com.nci.syncengine.wsbg.service.SFSQ_YHZHService yhzhService;

	private static String WSDL_ADDRESS = PropUtil
			.getProperty("service_dbsx_wsdlAddress");
	private static String SYSTEM = PropUtil.getProperty("service_dbsx_system");
	private static String WS_USERNAME = PropUtil
			.getProperty("service_dbsx_username");
	private static String WS_PASSWORD = PropUtil
			.getProperty("service_dbsx_password");

	// 跳转地址
	private static String DBSX_ADDRESS = PropUtil
			.getProperty("service_dbsx_address");

	private static NoticeService noticeService = null;

	private static NoticeService getNoticeService() throws AxisFault {
		if (noticeService == null) {
			noticeService = new NoticeService(WSDL_ADDRESS, WS_USERNAME,
					WS_PASSWORD);
		}
		return noticeService;
	}
}
