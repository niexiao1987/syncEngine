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
		boolean stick = tztg.getJJCD() != "0";// 根据紧急程度决定是否置顶
		getNotificationService().saveOrUpdate(tztg.getID(), SYSTEM,
				tztg.getBT(), getContent(tztg), getUrl(tztg), USER_ID,
				ORGANIZATION_ID, stick, tztg.getFBRQ(), tztg.getYXRQ());
	}

	/**
	 * 保存并发布通知公告
	 * 
	 * @param tztg
	 *            通知通告实体
	 */
	public static void saveAndPublish(SWGL_TZTG tztg) throws AxisFault,
			RemoteException {
		boolean stick = tztg.getJJCD() != "0";// 根据紧急程度决定是否置顶
		// 网上办公的通知公告都是针对所有人的 所以isAllUser = true permCode=null
		getNotificationService().saveAndPublish(tztg.getID(), SYSTEM,
				tztg.getBT(), getContent(tztg), getUrl(tztg), USER_ID,
				ORGANIZATION_ID, stick, true, null, tztg.getFBRQ(),
				tztg.getYXRQ());
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

	/**
	 * 获取内容HTML
	 * 
	 * @param tztg
	 *            通知通告实体
	 * @return
	 */
	private static String getContent(SWGL_TZTG tztg) {
		// todo：判断是否有附件，有的话在内容最后加上附件的链接
		return tztg.getNR();
	}

	/**
	 * 获取URL
	 * 
	 * @param tztg
	 *            通知通告实体
	 * @return
	 */
	private static String getUrl(SWGL_TZTG tztg) {
		// 内容类别为1的时候是外部链接，内容是一个url，其他情况是普通类型
		if (tztg.getNRLB() == "1") {
			return tztg.getNR();
		}
		return null;
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
