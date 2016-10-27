package com.nci.syncengine.wsbg.engine;

import java.rmi.RemoteException;
import java.util.Date;

import org.apache.axis.AxisFault;

import com.nci.syncengine.api.service.NotificationService;
import com.nci.syncengine.util.DateUtil;
import com.nci.syncengine.util.PropUtil;
import com.nci.syncengine.wsbg.entity.SWGL_TZTG;

/**
 * 网上办公通知公告引擎
 * 
 * @author Danny
 *
 */
public class TZTGEngine {

	/**
	 * 保存或更新通知通告
	 * 
	 * @param tztg
	 *            通知通告实体
	 */
	public static void saveOrUpdate(SWGL_TZTG tztg) throws AxisFault,
			RemoteException {
		String url = tztg.getNRLB() == "0" ? null : null;// 根据内容类别决定是否有url，有的话为附件下载地址？
		boolean stick = tztg.getJJCD() != "0";// 根据紧急程度决定是否置顶
		getNotificationService().saveOrUpdate(tztg.getID(), SYSTEM,
				tztg.getBT(), tztg.getNR(), url, USER_ID, ORGANIZATION_ID,
				stick, tztg.getFBRQ(), tztg.getYXRQ());
	}

	/**
	 * 保存并发布通知公告
	 * 
	 * @param tztg
	 *            通知通告实体
	 */
	public static void saveAndPublish(SWGL_TZTG tztg) throws AxisFault,
			RemoteException {

		String url = tztg.getNRLB() == "0" ? null : null;// 根据内容类别决定是否有url，有的话为附件下载地址？
		boolean stick = tztg.getJJCD() != "0";// 根据紧急程度决定是否置顶
		// 网上办公的通知公告都是针对所有人的 所以isAllUser = true permCode=null
		getNotificationService().saveAndPublish(tztg.getID(), SYSTEM,
				tztg.getBT(), tztg.getNR(), url, USER_ID, ORGANIZATION_ID,
				stick, true, null, tztg.getFBRQ(), tztg.getYXRQ());
	}

	/**
	 * 删除通知公告
	 * 
	 * @param tztg
	 *            通知通告实体
	 */
	public static void delete(SWGL_TZTG tztg) throws RemoteException {
		getNotificationService().delete(tztg.getID(), SYSTEM);
	}

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

	private static NotificationService getNotificationService()
			throws AxisFault {
		if (notificationService == null) {
			notificationService = new NotificationService(WSDL_ADDRESS,
					WS_USERNAME, WS_PASSWORD);
		}
		return notificationService;
	}

	/*************************************************/
	// /**
	// * 置顶通知公告
	// *
	// * @param tztg
	// * 通知通告实体
	// */
	// public static void stick(SWGL_TZTG tztg) throws AxisFault,
	// RemoteException {
	// getNotificationService().stick(tztg.getID(), SYSTEM);
	// }
	//
	// /**
	// * 取消置顶通知公告
	// *
	// * @param tztg
	// * 通知通告实体
	// */
	// public static void cancelStick(SWGL_TZTG tztg) throws RemoteException {
	// getNotificationService().cancelStick(tztg.getID(), SYSTEM);
	// }

	// public static void publish(SWGL_TZTG tztg) throws AxisFault,
	// RemoteException {
	// getNotificationService().publish(tztg.getID(), SYSTEM, true, null);
	// }
	//
	// public static void revocation(SWGL_TZTG tztg) throws AxisFault,
	// RemoteException {
	// getNotificationService().revocation(tztg.getID(), SYSTEM);
	// }

}
