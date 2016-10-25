package com.nci.wjxy.portal.service.http;

public class NoticeServiceSoapProxy implements com.nci.wjxy.portal.service.http.NoticeServiceSoap {
  private String _endpoint = null;
  private com.nci.wjxy.portal.service.http.NoticeServiceSoap noticeServiceSoap = null;
  
  public NoticeServiceSoapProxy() {
    _initNoticeServiceSoapProxy();
  }
  
  public NoticeServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initNoticeServiceSoapProxy();
  }
  
  private void _initNoticeServiceSoapProxy() {
    try {
      noticeServiceSoap = (new com.nci.wjxy.portal.service.http.NoticeServiceSoapServiceLocator()).getPlugin_wjxy_NoticeService();
      if (noticeServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)noticeServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)noticeServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (noticeServiceSoap != null)
      ((javax.xml.rpc.Stub)noticeServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.nci.wjxy.portal.service.http.NoticeServiceSoap getNoticeServiceSoap() {
    if (noticeServiceSoap == null)
      _initNoticeServiceSoapProxy();
    return noticeServiceSoap;
  }
  
  public com.nci.wjxy.portal.model.NoticeSoap addNotice(java.lang.String className, java.lang.String classId, java.lang.String type, java.lang.String taskId, java.lang.String title, java.lang.String content, java.lang.String url) throws java.rmi.RemoteException{
    if (noticeServiceSoap == null)
      _initNoticeServiceSoapProxy();
    return noticeServiceSoap.addNotice(className, classId, type, taskId, title, content, url);
  }
  
  public boolean completedNotice(java.lang.String type, java.lang.String taskId) throws java.rmi.RemoteException{
    if (noticeServiceSoap == null)
      _initNoticeServiceSoapProxy();
    return noticeServiceSoap.completedNotice(type, taskId);
  }
  
  public java.lang.String testNotice(java.lang.String str) throws java.rmi.RemoteException{
    if (noticeServiceSoap == null)
      _initNoticeServiceSoapProxy();
    return noticeServiceSoap.testNotice(str);
  }
  
  
}