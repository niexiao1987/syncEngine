package com.nci.syncengine.wsbg.service.impl;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.apache.axis.AxisFault;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nci.syncengine.api.service.NotificationService;
import com.nci.syncengine.util.DateUtil;
import com.nci.syncengine.util.PropUtil;
import com.nci.syncengine.wsbg.engine.TZTGEngine;
import com.nci.syncengine.wsbg.entity.SWGL_TZTG;
import com.nci.syncengine.wsbg.service.SWGL_TZTGService;

@RunWith(SpringJUnit4ClassRunner.class)
// 用于配置spring中测试的环境
@ContextConfiguration(locations = { "classpath:config/application-context.xml" })
// 用于指定配置文件所在的位置
public class WS_NotificationTest {

	private static String WSDL_ADDRESS = PropUtil
			.getProperty("service_tzgg_wsdlAddress");
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
			notificationService = new NotificationService(WSDL_ADDRESS,
					WS_USERNAME, WS_PASSWORD);
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

	@Autowired
	private com.nci.syncengine.wsbg.service.SWGL_TZTGService SWGL_TZTGService;

	@Test
	public void testEngine() throws RemoteException {
		SWGL_TZTG SWGL_TZTG = SWGL_TZTGService
				.findById("009293072B5E4BF79027762ACB36C4D1");
		SWGL_TZTG.setYXRQ(DateUtil.getDate(new Date(), Calendar.DATE, 5));
		System.out.println(SWGL_TZTG);

		//TZTGEngine.saveAndPublish(SWGL_TZTG);
	}

}
