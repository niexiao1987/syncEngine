package com.nci.wjxy.notification.service.http;

public class N_NotificationServiceSoapProxy implements com.nci.wjxy.notification.service.http.N_NotificationServiceSoap {
  private String _endpoint = null;
  private com.nci.wjxy.notification.service.http.N_NotificationServiceSoap n_NotificationServiceSoap = null;
  
  public N_NotificationServiceSoapProxy() {
    _initN_NotificationServiceSoapProxy();
  }
  
  public N_NotificationServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initN_NotificationServiceSoapProxy();
  }
  
  private void _initN_NotificationServiceSoapProxy() {
    try {
      n_NotificationServiceSoap = (new com.nci.wjxy.notification.service.http.N_NotificationServiceSoapServiceLocator()).getPlugin_wjxy_N_NotificationService();
      if (n_NotificationServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)n_NotificationServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)n_NotificationServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (n_NotificationServiceSoap != null)
      ((javax.xml.rpc.Stub)n_NotificationServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.nci.wjxy.notification.service.http.N_NotificationServiceSoap getN_NotificationServiceSoap() {
    if (n_NotificationServiceSoap == null)
      _initN_NotificationServiceSoapProxy();
    return n_NotificationServiceSoap;
  }
  
  public void cancelStick(java.lang.String taskId, java.lang.String system) throws java.rmi.RemoteException{
    if (n_NotificationServiceSoap == null)
      _initN_NotificationServiceSoapProxy();
    n_NotificationServiceSoap.cancelStick(taskId, system);
  }
  
  public void delete(java.lang.String taskId, java.lang.String system) throws java.rmi.RemoteException{
    if (n_NotificationServiceSoap == null)
      _initN_NotificationServiceSoapProxy();
    n_NotificationServiceSoap.delete(taskId, system);
  }
  
  public void publish(java.lang.String taskId, java.lang.String system, boolean isAllUser, java.lang.String permCode) throws java.rmi.RemoteException{
    if (n_NotificationServiceSoap == null)
      _initN_NotificationServiceSoapProxy();
    n_NotificationServiceSoap.publish(taskId, system, isAllUser, permCode);
  }
  
  public void revocation(java.lang.String taskId, java.lang.String system) throws java.rmi.RemoteException{
    if (n_NotificationServiceSoap == null)
      _initN_NotificationServiceSoapProxy();
    n_NotificationServiceSoap.revocation(taskId, system);
  }
  
  public void stick(java.lang.String taskId, java.lang.String system) throws java.rmi.RemoteException{
    if (n_NotificationServiceSoap == null)
      _initN_NotificationServiceSoapProxy();
    n_NotificationServiceSoap.stick(taskId, system);
  }
  
  public com.nci.wjxy.notification.model.N_NotificationSoap saveAndPublish(java.lang.String taskId, java.lang.String system, java.lang.String title, java.lang.String content, java.lang.String url, java.lang.String userId, java.lang.String organizationId, boolean stick, boolean isAllUser, java.lang.String permCode, java.util.Calendar publishedDate, java.util.Calendar expiryDate) throws java.rmi.RemoteException{
    if (n_NotificationServiceSoap == null)
      _initN_NotificationServiceSoapProxy();
    return n_NotificationServiceSoap.saveAndPublish(taskId, system, title, content, url, userId, organizationId, stick, isAllUser, permCode, publishedDate, expiryDate);
  }
  
  public com.nci.wjxy.notification.model.N_NotificationSoap saveOrUpdate(java.lang.String taskId, java.lang.String system, java.lang.String title, java.lang.String content, java.lang.String url, java.lang.String userId, java.lang.String organizationId, boolean stick, java.util.Calendar publishedDate, java.util.Calendar expiryDate) throws java.rmi.RemoteException{
    if (n_NotificationServiceSoap == null)
      _initN_NotificationServiceSoapProxy();
    return n_NotificationServiceSoap.saveOrUpdate(taskId, system, title, content, url, userId, organizationId, stick, publishedDate, expiryDate);
  }
  
  
}