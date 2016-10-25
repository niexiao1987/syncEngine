package com.nci.syncengine.api.service;

import java.rmi.RemoteException;

import org.apache.axis.AxisFault;

import com.nci.wjxy.notification.service.http.Plugin_wjxy_N_NotificationServiceSoapBindingStub;
import com.nci.wjxy.portal.service.http.Plugin_wjxy_NoticeServiceSoapBindingStub;

/**
 * 待办事项远程调用服务类 测试地址：http://10.10.9.9:6060/notice-portlet/api/axis/
 * Plugin_wjxy_NoticeService?wsdl
 * 
 * @author Danny
 *
 */
public class NoticeService {

	public NoticeService(String webServiceIP, String userName, String password)
			throws AxisFault {
		this.wsdlAddress = WS_WSDL_ADDRESS.replace("@", webServiceIP);
		getStub().setUsername(userName.trim());
		getStub().setPassword(password.trim());
	}

	/**
	 * 添加待办事项
	 * @param className 待办事项目标受众名称（user,organization）
	 * @param classId 目标受众Id
	 * @param type 业务系统代码
	 * @param taskId 业务系统中待办事项的Id
	 * @param title 待办事项标题
	 * @param content 待办事项内容
	 * @param url 待办事项连接
	 */
	public void addNotice(String className, String classId, String type,
			String taskId, String title, String content, String url)
			throws AxisFault, RemoteException {
		getStub().addNotice(className, classId, type, taskId, title, content,
				url);
	}

	/**
	 * 完成待办事项
	 * @param type 业务系统代码
	 * @param taskId 业务系统中待办事项的Id
	 */
	public void completedNotice(String type, String taskId) throws AxisFault,
			RemoteException {
		getStub().completedNotice(type, taskId);
	}

	private static String WS_WSDL_ADDRESS = "http://@/notice-portlet/api/axis/Plugin_wjxy_NoticeService?wsdl";
	private String wsdlAddress;
	private Plugin_wjxy_NoticeServiceSoapBindingStub stub = null;

	private Plugin_wjxy_NoticeServiceSoapBindingStub getStub() throws AxisFault {
		if (this.stub == null) {
			this.stub = new Plugin_wjxy_NoticeServiceSoapBindingStub();
			this.stub._setProperty("javax.xml.rpc.service.endpoint.address",
					this.wsdlAddress.trim());
		}
		return this.stub;
	}

}
