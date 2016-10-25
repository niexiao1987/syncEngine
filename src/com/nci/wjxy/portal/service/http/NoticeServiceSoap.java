/**
 * NoticeServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nci.wjxy.portal.service.http;

public interface NoticeServiceSoap extends java.rmi.Remote {
    public com.nci.wjxy.portal.model.NoticeSoap addNotice(java.lang.String className, java.lang.String classId, java.lang.String type, java.lang.String taskId, java.lang.String title, java.lang.String content, java.lang.String url) throws java.rmi.RemoteException;
    public boolean completedNotice(java.lang.String type, java.lang.String taskId) throws java.rmi.RemoteException;
    public java.lang.String testNotice(java.lang.String str) throws java.rmi.RemoteException;
}
