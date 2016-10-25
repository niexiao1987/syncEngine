/**
 * N_NotificationSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nci.wjxy.notification.model;

public class N_NotificationSoap  implements java.io.Serializable {
    private java.lang.String content;

    private java.util.Calendar createDate;

    private java.util.Calendar expiryDate;

    private java.util.Calendar modifiedDate;

    private long notificationId;

    private long organizationId;

    private long primaryKey;

    private java.util.Calendar publishedDate;

    private int status;

    private boolean stick;

    private java.lang.String system;

    private java.lang.String taskId;

    private java.lang.String title;

    private java.lang.String url;

    private long userId;

    public N_NotificationSoap() {
    }

    public N_NotificationSoap(
           java.lang.String content,
           java.util.Calendar createDate,
           java.util.Calendar expiryDate,
           java.util.Calendar modifiedDate,
           long notificationId,
           long organizationId,
           long primaryKey,
           java.util.Calendar publishedDate,
           int status,
           boolean stick,
           java.lang.String system,
           java.lang.String taskId,
           java.lang.String title,
           java.lang.String url,
           long userId) {
           this.content = content;
           this.createDate = createDate;
           this.expiryDate = expiryDate;
           this.modifiedDate = modifiedDate;
           this.notificationId = notificationId;
           this.organizationId = organizationId;
           this.primaryKey = primaryKey;
           this.publishedDate = publishedDate;
           this.status = status;
           this.stick = stick;
           this.system = system;
           this.taskId = taskId;
           this.title = title;
           this.url = url;
           this.userId = userId;
    }


    /**
     * Gets the content value for this N_NotificationSoap.
     * 
     * @return content
     */
    public java.lang.String getContent() {
        return content;
    }


    /**
     * Sets the content value for this N_NotificationSoap.
     * 
     * @param content
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }


    /**
     * Gets the createDate value for this N_NotificationSoap.
     * 
     * @return createDate
     */
    public java.util.Calendar getCreateDate() {
        return createDate;
    }


    /**
     * Sets the createDate value for this N_NotificationSoap.
     * 
     * @param createDate
     */
    public void setCreateDate(java.util.Calendar createDate) {
        this.createDate = createDate;
    }


    /**
     * Gets the expiryDate value for this N_NotificationSoap.
     * 
     * @return expiryDate
     */
    public java.util.Calendar getExpiryDate() {
        return expiryDate;
    }


    /**
     * Sets the expiryDate value for this N_NotificationSoap.
     * 
     * @param expiryDate
     */
    public void setExpiryDate(java.util.Calendar expiryDate) {
        this.expiryDate = expiryDate;
    }


    /**
     * Gets the modifiedDate value for this N_NotificationSoap.
     * 
     * @return modifiedDate
     */
    public java.util.Calendar getModifiedDate() {
        return modifiedDate;
    }


    /**
     * Sets the modifiedDate value for this N_NotificationSoap.
     * 
     * @param modifiedDate
     */
    public void setModifiedDate(java.util.Calendar modifiedDate) {
        this.modifiedDate = modifiedDate;
    }


    /**
     * Gets the notificationId value for this N_NotificationSoap.
     * 
     * @return notificationId
     */
    public long getNotificationId() {
        return notificationId;
    }


    /**
     * Sets the notificationId value for this N_NotificationSoap.
     * 
     * @param notificationId
     */
    public void setNotificationId(long notificationId) {
        this.notificationId = notificationId;
    }


    /**
     * Gets the organizationId value for this N_NotificationSoap.
     * 
     * @return organizationId
     */
    public long getOrganizationId() {
        return organizationId;
    }


    /**
     * Sets the organizationId value for this N_NotificationSoap.
     * 
     * @param organizationId
     */
    public void setOrganizationId(long organizationId) {
        this.organizationId = organizationId;
    }


    /**
     * Gets the primaryKey value for this N_NotificationSoap.
     * 
     * @return primaryKey
     */
    public long getPrimaryKey() {
        return primaryKey;
    }


    /**
     * Sets the primaryKey value for this N_NotificationSoap.
     * 
     * @param primaryKey
     */
    public void setPrimaryKey(long primaryKey) {
        this.primaryKey = primaryKey;
    }


    /**
     * Gets the publishedDate value for this N_NotificationSoap.
     * 
     * @return publishedDate
     */
    public java.util.Calendar getPublishedDate() {
        return publishedDate;
    }


    /**
     * Sets the publishedDate value for this N_NotificationSoap.
     * 
     * @param publishedDate
     */
    public void setPublishedDate(java.util.Calendar publishedDate) {
        this.publishedDate = publishedDate;
    }


    /**
     * Gets the status value for this N_NotificationSoap.
     * 
     * @return status
     */
    public int getStatus() {
        return status;
    }


    /**
     * Sets the status value for this N_NotificationSoap.
     * 
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }


    /**
     * Gets the stick value for this N_NotificationSoap.
     * 
     * @return stick
     */
    public boolean isStick() {
        return stick;
    }


    /**
     * Sets the stick value for this N_NotificationSoap.
     * 
     * @param stick
     */
    public void setStick(boolean stick) {
        this.stick = stick;
    }


    /**
     * Gets the system value for this N_NotificationSoap.
     * 
     * @return system
     */
    public java.lang.String getSystem() {
        return system;
    }


    /**
     * Sets the system value for this N_NotificationSoap.
     * 
     * @param system
     */
    public void setSystem(java.lang.String system) {
        this.system = system;
    }


    /**
     * Gets the taskId value for this N_NotificationSoap.
     * 
     * @return taskId
     */
    public java.lang.String getTaskId() {
        return taskId;
    }


    /**
     * Sets the taskId value for this N_NotificationSoap.
     * 
     * @param taskId
     */
    public void setTaskId(java.lang.String taskId) {
        this.taskId = taskId;
    }


    /**
     * Gets the title value for this N_NotificationSoap.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this N_NotificationSoap.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the url value for this N_NotificationSoap.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this N_NotificationSoap.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }


    /**
     * Gets the userId value for this N_NotificationSoap.
     * 
     * @return userId
     */
    public long getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this N_NotificationSoap.
     * 
     * @param userId
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof N_NotificationSoap)) return false;
        N_NotificationSoap other = (N_NotificationSoap) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.content==null && other.getContent()==null) || 
             (this.content!=null &&
              this.content.equals(other.getContent()))) &&
            ((this.createDate==null && other.getCreateDate()==null) || 
             (this.createDate!=null &&
              this.createDate.equals(other.getCreateDate()))) &&
            ((this.expiryDate==null && other.getExpiryDate()==null) || 
             (this.expiryDate!=null &&
              this.expiryDate.equals(other.getExpiryDate()))) &&
            ((this.modifiedDate==null && other.getModifiedDate()==null) || 
             (this.modifiedDate!=null &&
              this.modifiedDate.equals(other.getModifiedDate()))) &&
            this.notificationId == other.getNotificationId() &&
            this.organizationId == other.getOrganizationId() &&
            this.primaryKey == other.getPrimaryKey() &&
            ((this.publishedDate==null && other.getPublishedDate()==null) || 
             (this.publishedDate!=null &&
              this.publishedDate.equals(other.getPublishedDate()))) &&
            this.status == other.getStatus() &&
            this.stick == other.isStick() &&
            ((this.system==null && other.getSystem()==null) || 
             (this.system!=null &&
              this.system.equals(other.getSystem()))) &&
            ((this.taskId==null && other.getTaskId()==null) || 
             (this.taskId!=null &&
              this.taskId.equals(other.getTaskId()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl()))) &&
            this.userId == other.getUserId();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getContent() != null) {
            _hashCode += getContent().hashCode();
        }
        if (getCreateDate() != null) {
            _hashCode += getCreateDate().hashCode();
        }
        if (getExpiryDate() != null) {
            _hashCode += getExpiryDate().hashCode();
        }
        if (getModifiedDate() != null) {
            _hashCode += getModifiedDate().hashCode();
        }
        _hashCode += new Long(getNotificationId()).hashCode();
        _hashCode += new Long(getOrganizationId()).hashCode();
        _hashCode += new Long(getPrimaryKey()).hashCode();
        if (getPublishedDate() != null) {
            _hashCode += getPublishedDate().hashCode();
        }
        _hashCode += getStatus();
        _hashCode += (isStick() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSystem() != null) {
            _hashCode += getSystem().hashCode();
        }
        if (getTaskId() != null) {
            _hashCode += getTaskId().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        _hashCode += new Long(getUserId()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(N_NotificationSoap.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.notification.wjxy.nci.com", "N_NotificationSoap"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("content");
        elemField.setXmlName(new javax.xml.namespace.QName("", "content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "createDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expiryDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "expiryDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modifiedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modifiedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notificationId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "notificationId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("organizationId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "organizationId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("primaryKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "primaryKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publishedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "publishedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stick");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stick"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("system");
        elemField.setXmlName(new javax.xml.namespace.QName("", "system"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taskId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "taskId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("", "title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
