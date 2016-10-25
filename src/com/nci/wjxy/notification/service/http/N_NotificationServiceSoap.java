/**
 * N_NotificationServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nci.wjxy.notification.service.http;

public interface N_NotificationServiceSoap extends java.rmi.Remote {
    public void cancelStick(java.lang.String taskId, java.lang.String system) throws java.rmi.RemoteException;
    public void delete(java.lang.String taskId, java.lang.String system) throws java.rmi.RemoteException;
    public void publish(java.lang.String taskId, java.lang.String system, boolean isAllUser, java.lang.String permCode) throws java.rmi.RemoteException;
    public void revocation(java.lang.String taskId, java.lang.String system) throws java.rmi.RemoteException;
    public com.nci.wjxy.notification.model.N_NotificationSoap saveAndPublish(java.lang.String taskId, java.lang.String system, java.lang.String title, java.lang.String content, java.lang.String url, java.lang.String userId, java.lang.String organizationId, boolean stick, boolean isAllUser, java.lang.String permCode, java.util.Calendar publishedDate, java.util.Calendar expiryDate) throws java.rmi.RemoteException;
    public com.nci.wjxy.notification.model.N_NotificationSoap saveOrUpdate(java.lang.String taskId, java.lang.String system, java.lang.String title, java.lang.String content, java.lang.String url, java.lang.String userId, java.lang.String organizationId, boolean stick, java.util.Calendar publishedDate, java.util.Calendar expiryDate) throws java.rmi.RemoteException;
    public void stick(java.lang.String taskId, java.lang.String system) throws java.rmi.RemoteException;
}
