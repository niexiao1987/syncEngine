/**
 * NoticeServiceSoapServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nci.wjxy.portal.service.http;

public class NoticeServiceSoapServiceLocator extends org.apache.axis.client.Service implements com.nci.wjxy.portal.service.http.NoticeServiceSoapService {

    public NoticeServiceSoapServiceLocator() {
    }


    public NoticeServiceSoapServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public NoticeServiceSoapServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Plugin_wjxy_NoticeService
    private java.lang.String Plugin_wjxy_NoticeService_address = "http://10.10.9.9:6060/notice-portlet/api/axis/Plugin_wjxy_NoticeService";

    public java.lang.String getPlugin_wjxy_NoticeServiceAddress() {
        return Plugin_wjxy_NoticeService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Plugin_wjxy_NoticeServiceWSDDServiceName = "Plugin_wjxy_NoticeService";

    public java.lang.String getPlugin_wjxy_NoticeServiceWSDDServiceName() {
        return Plugin_wjxy_NoticeServiceWSDDServiceName;
    }

    public void setPlugin_wjxy_NoticeServiceWSDDServiceName(java.lang.String name) {
        Plugin_wjxy_NoticeServiceWSDDServiceName = name;
    }

    public com.nci.wjxy.portal.service.http.NoticeServiceSoap getPlugin_wjxy_NoticeService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Plugin_wjxy_NoticeService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPlugin_wjxy_NoticeService(endpoint);
    }

    public com.nci.wjxy.portal.service.http.NoticeServiceSoap getPlugin_wjxy_NoticeService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.nci.wjxy.portal.service.http.Plugin_wjxy_NoticeServiceSoapBindingStub _stub = new com.nci.wjxy.portal.service.http.Plugin_wjxy_NoticeServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getPlugin_wjxy_NoticeServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPlugin_wjxy_NoticeServiceEndpointAddress(java.lang.String address) {
        Plugin_wjxy_NoticeService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.nci.wjxy.portal.service.http.NoticeServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.nci.wjxy.portal.service.http.Plugin_wjxy_NoticeServiceSoapBindingStub _stub = new com.nci.wjxy.portal.service.http.Plugin_wjxy_NoticeServiceSoapBindingStub(new java.net.URL(Plugin_wjxy_NoticeService_address), this);
                _stub.setPortName(getPlugin_wjxy_NoticeServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Plugin_wjxy_NoticeService".equals(inputPortName)) {
            return getPlugin_wjxy_NoticeService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:http.service.portal.wjxy.nci.com", "NoticeServiceSoapService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:http.service.portal.wjxy.nci.com", "Plugin_wjxy_NoticeService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Plugin_wjxy_NoticeService".equals(portName)) {
            setPlugin_wjxy_NoticeServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
