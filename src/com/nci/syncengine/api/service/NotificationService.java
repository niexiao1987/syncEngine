package com.nci.syncengine.api.service;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;

import org.apache.axis.AxisFault;

import com.nci.syncengine.util.DateUtil;
import com.nci.wjxy.notification.service.http.Plugin_wjxy_N_NotificationServiceSoapBindingStub;

/**
 * 通知公告远程调用服务类
 * 
 * @author Danny
 *
 */
public class NotificationService {

	private static String WS_WSDL_ADDRESS = "http://@/notification-portlet/api/axis/Plugin_wjxy_N_NotificationService?wsdl";
	private String wsdlAddress;
	private Plugin_wjxy_N_NotificationServiceSoapBindingStub stub = null;

	public NotificationService(String webServiceIP, String userName,
			String password) throws AxisFault {
		this.wsdlAddress = WS_WSDL_ADDRESS.replace("@", webServiceIP);
		getStub().setUsername(userName.trim());
		getStub().setPassword(password.trim());
	}

	/**
	 * 保存或更新通知公告
	 * 
	 * @param taskId
	 *            业务系统中通知公告的ID
	 * @param system
	 *            业务系统代码
	 * @param title
	 *            通知公告标题
	 * @param content
	 *            通知公告内容
	 * @param url
	 *            通知公告连接
	 * @param userId
	 *            发送通知公告的用户ID 可以为空
	 * @param organizationId
	 *            发送通知公告的组织机构ID 可以为空
	 * @param stick
	 *            是否置顶
	 * @param publishedDate
	 *            发布时间
	 * @param expiryDate
	 *            失效时间
	 */
	public void saveOrUpdate(String taskId, String system, String title,
			String content, String url, String userId, String organizationId,
			boolean stick, Date publishedDate, Date expiryDate)
			throws AxisFault, RemoteException {
		getStub().saveOrUpdate(taskId, system, title, content, url, userId,
				organizationId, stick, DateUtil.toCalendar(publishedDate),
				DateUtil.toCalendar(expiryDate));
	}

	/**
	 * 发布通知公告
	 * 
	 * @param taskId
	 *            业务系统中通知公告的ID
	 * @param system
	 *            业务系统代码
	 * @param isAllUser
	 *            是否是所有人可见
	 * @param permCode
	 *            权限代码，参见教育教学平台，可以为空
	 */
	public void publish(String taskId, String system, boolean isAllUser,
			String permCode) throws AxisFault, RemoteException {
		getStub().publish(taskId, system, isAllUser, permCode);
	}

	/**
	 * 取消发布
	 * 
	 * @param taskId
	 *            业务系统中通知公告的ID
	 * @param system
	 *            业务系统代码
	 */
	public void revocation(String taskId, String system) throws AxisFault,
			RemoteException {
		getStub().revocation(taskId, system);
	}

	/**
	 * 保存并发布通知公告
	 * 
	 * @param taskId
	 *            业务系统中通知公告的ID
	 * @param system
	 *            业务系统代码
	 * @param title
	 *            通知公告标题
	 * @param content
	 *            通知公告内容
	 * @param url
	 *            通知公告连接
	 * @param userId
	 *            发送通知公告的用户ID 可以为空
	 * @param organizationId
	 *            发送通知公告的组织机构ID 可以为空
	 * @param stick
	 *            是否置顶
	 * @param isAllUser
	 *            是否是所有人可见
	 * @param permCode
	 *            权限代码，参见教育教学平台，可以为空
	 * @param publishedDate
	 *            发布时间
	 * @param expiryDate
	 *            失效时间
	 */
	public void saveAndPublish(String taskId, String system, String title,
			String content, String url, String userId, String organizationId,
			boolean stick, boolean isAllUser, String permCode,
			Date publishedDate, Date expiryDate) throws AxisFault,
			RemoteException {

		getStub().saveAndPublish(taskId, system, title, content, url, userId,
				organizationId, stick, isAllUser, permCode,
				DateUtil.toCalendar(publishedDate),
				DateUtil.toCalendar(expiryDate));
	}

	/**
	 * 置顶通知公告
	 * 
	 * @param taskId
	 *            业务系统中通知公告的ID
	 * @param system
	 *            业务系统代码
	 */
	public void stick(String taskId, String system) throws AxisFault,
			RemoteException {
		getStub().stick(taskId, system);
	}

	/**
	 * 取消置顶通知公告
	 * 
	 * @param taskId
	 *            业务系统中通知公告的ID
	 * @param system
	 *            业务系统代码
	 */
	public void cancelStick(String taskId, String system)
			throws RemoteException {
		getStub().cancelStick(taskId, system);
	}

	/**
	 * 删除通知公告
	 * 
	 * @param taskId
	 *            业务系统中通知公告的ID
	 * @param system
	 *            业务系统代码
	 */
	public void delete(String taskId, String system) throws RemoteException {
		getStub().delete(taskId, system);
	}

	private Plugin_wjxy_N_NotificationServiceSoapBindingStub getStub()
			throws AxisFault {
		if (this.stub == null) {
			this.stub = new Plugin_wjxy_N_NotificationServiceSoapBindingStub();
			this.stub._setProperty("javax.xml.rpc.service.endpoint.address",
					this.wsdlAddress.trim());
		}
		return this.stub;
	}

}
