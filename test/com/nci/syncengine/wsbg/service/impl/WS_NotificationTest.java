package com.nci.syncengine.wsbg.service.impl;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.apache.axis.AxisFault;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nci.syncengine.api.service.NotificationService;
import com.nci.syncengine.util.DateUtil;
import com.nci.syncengine.util.PropUtil;

@RunWith(SpringJUnit4ClassRunner.class)
// 用于配置spring中测试的环境
@ContextConfiguration(locations = { "classpath:config/application-context.xml" })
// 用于指定配置文件所在的位置
public class WS_NotificationTest {

	private static String IP = PropUtil.getProperty("service_tzgg_IP");
	private static String SYSTEM = PropUtil.getProperty("service_tzgg_system");
	private static String USER_ID = "";
	private static String ORGANIZATION_ID = "";

	private static String WS_USERNAME = PropUtil
			.getProperty("service_tzgg_username");
	private static String WS_PASSWORD = PropUtil
			.getProperty("service_tzgg_password");

	private static NotificationService notificationService = null;

	private NotificationService getNotificationService() throws AxisFault {
		if (notificationService == null) {
			notificationService = new NotificationService(IP, WS_USERNAME,
					WS_PASSWORD);
		}
		return notificationService;
	}

	@Test
	public void testSaveAndPublish() throws RemoteException {
		String taskId = UUID.randomUUID().toString();
		String title = "wsbg-title";
		String content = "content";
		String url = "url";
		boolean stick = false;
		boolean isAllUser = true;
		String permCode = "";
		Date publishedDate = new Date();
		Date expiryDate = DateUtil.getDate(publishedDate, Calendar.DATE, 3);
		getNotificationService().saveAndPublish(taskId, SYSTEM, title, content,
				url, USER_ID, ORGANIZATION_ID, stick, isAllUser, permCode,
				null, null);
	}

}
