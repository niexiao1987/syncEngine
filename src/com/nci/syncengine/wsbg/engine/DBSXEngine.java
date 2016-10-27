package com.nci.syncengine.wsbg.engine;

import java.rmi.RemoteException;

import org.apache.axis.AxisFault;

import com.nci.syncengine.api.service.NoticeService;
import com.nci.syncengine.util.PropUtil;
import com.nci.syncengine.wsbg.entity.DBZHJC_DBSX;
import com.nci.wjxy.portal.service.http.Plugin_wjxy_NoticeServiceSoapBindingStub;

/**
 * 网上办公待办事项引擎
 * 
 * @author Danny
 *
 */
public class DBSXEngine {

	private static String WSDL_ADDRESS = PropUtil
			.getProperty("service_dbsx_wsdlAddress");
	private static String SYSTEM = PropUtil.getProperty("service_dbsx_system");
	private static String WS_USERNAME = PropUtil
			.getProperty("service_dbsx_username");
	private static String WS_PASSWORD = PropUtil
			.getProperty("service_dbsx_password");

	private static String USER_ID = "";
	private static String ORGANIZATION_ID = "";

	private static NoticeService noticeService = null;

	private static NoticeService getNoticeService() throws AxisFault {
		if (noticeService == null) {
			noticeService = new NoticeService(WSDL_ADDRESS, WS_USERNAME,
					WS_PASSWORD);
		}
		return noticeService;
	}

//	public static void addNotice(DBZHJC_DBSX dbsx) throws AxisFault,
//			RemoteException {
//		String className = "user";// 根据待办事项类型决定发送受众
//		String classId;
//		getNoticeService().addNotice(className, classId, SYSTEM, dbsx.getID(),
//				dbsx.getBT(), "", dbsx.getBTLJ());
//	}

	public static void completedNotice(DBZHJC_DBSX dbsx) throws AxisFault,
			RemoteException {
		getNoticeService().completedNotice(SYSTEM, dbsx.getID());
	}

}
