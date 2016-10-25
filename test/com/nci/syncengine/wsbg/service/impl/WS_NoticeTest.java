package com.nci.syncengine.wsbg.service.impl;

import java.rmi.RemoteException;
import java.util.UUID;

import org.apache.axis.AxisFault;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nci.syncengine.api.service.NoticeService;
import com.nci.syncengine.api.service.NotificationService;
import com.nci.syncengine.util.PropUtil;

@RunWith(SpringJUnit4ClassRunner.class)
// 用于配置spring中测试的环境
@ContextConfiguration(locations = { "classpath:config/application-context.xml" })
// 用于指定配置文件所在的位置
public class WS_NoticeTest {

	private static String WSDL_ADDRESS = PropUtil.getProperty("service_dbsx_wsdlAddress");
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
			noticeService = new NoticeService(WSDL_ADDRESS, WS_USERNAME, WS_PASSWORD);
		}
		return noticeService;
	}

	@Test
	public void testAddNotice() throws RemoteException {
		String className="user";
		String classId="zhangjingren";
		String type="wsbg";
		String taskId = UUID.randomUUID().toString();
		String title = "wsbg-title";
		String content = "content";
		String url = "url";
		getNoticeService().addNotice(className, classId, type, taskId, title,
				content, url);
	}
	
	@Test
	public void testCompletedNotice() throws RemoteException {
		String type="wsbg";
		String taskId = "6e477154-c976-4eb0-8bac-edac0dccabec";
		getNoticeService().completedNotice(type, taskId);
	}

}
