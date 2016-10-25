/**
 * NoticeSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nci.wjxy.portal.model;

public class NoticeSoap  implements java.io.Serializable {
    private long classNameId;

    private long classPK;

    private long companyId;

    private boolean completed;

    private java.lang.String content;

    private java.util.Calendar createDate;

    private long groupId;

    private java.util.Calendar modifiedDate;

    private long noticeId;

    private long primaryKey;

    private java.lang.String taskId;

    private java.lang.String title;

    private java.lang.String type;

    private java.lang.String url;

    private long userId;

    private java.lang.String userName;

    private java.lang.String uuid;

    public NoticeSoap() {
    }

    public NoticeSoap(
           long classNameId,
           long classPK,
           long companyId,
           boolean completed,
           java.lang.String content,
           java.util.Calendar createDate,
           long groupId,
           java.util.Calendar modifiedDate,
           long noticeId,
           long primaryKey,
           java.lang.String taskId,
           java.lang.String title,
           java.lang.String type,
           java.lang.String url,
           long userId,
           java.lang.String userName,
           java.lang.String uuid) {
           this.classNameId = classNameId;
           this.classPK = classPK;
           this.companyId = companyId;
           this.completed = completed;
           this.content = content;
           this.createDate = createDate;
           this.groupId = groupId;
           this.modifiedDate = modifiedDate;
           this.noticeId = noticeId;
           this.primaryKey = primaryKey;
           this.taskId = taskId;
           this.title = title;
           this.type = type;
           this.url = url;
           this.userId = userId;
           this.userName = userName;
           this.uuid = uuid;
    }


    /**
     * Gets the classNameId value for this NoticeSoap.
     * 
     * @return classNameId
     */
    public long getClassNameId() {
        return classNameId;
    }


    /**
     * Sets the classNameId value for this NoticeSoap.
     * 
     * @param classNameId
     */
    public void setClassNameId(long classNameId) {
        this.classNameId = classNameId;
    }


    /**
     * Gets the classPK value for this NoticeSoap.
     * 
     * @return classPK
     */
    public long getClassPK() {
        return classPK;
    }


    /**
     * Sets the classPK value for this NoticeSoap.
     * 
     * @param classPK
     */
    public void setClassPK(long classPK) {
        this.classPK = classPK;
    }


    /**
     * Gets the companyId value for this NoticeSoap.
     * 
     * @return companyId
     */
    public long getCompanyId() {
        return companyId;
    }


    /**
     * Sets the companyId value for this NoticeSoap.
     * 
     * @param companyId
     */
    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }


    /**
     * Gets the completed value for this NoticeSoap.
     * 
     * @return completed
     */
    public boolean isCompleted() {
        return completed;
    }


    /**
     * Sets the completed value for this NoticeSoap.
     * 
     * @param completed
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


    /**
     * Gets the content value for this NoticeSoap.
     * 
     * @return content
     */
    public java.lang.String getContent() {
        return content;
    }


    /**
     * Sets the content value for this NoticeSoap.
     * 
     * @param content
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }


    /**
     * Gets the createDate value for this NoticeSoap.
     * 
     * @return createDate
     */
    public java.util.Calendar getCreateDate() {
        return createDate;
    }


    /**
     * Sets the createDate value for this NoticeSoap.
     * 
     * @param createDate
     */
    public void setCreateDate(java.util.Calendar createDate) {
        this.createDate = createDate;
    }


    /**
     * Gets the groupId value for this NoticeSoap.
     * 
     * @return groupId
     */
    public long getGroupId() {
        return groupId;
    }


    /**
     * Sets the groupId value for this NoticeSoap.
     * 
     * @param groupId
     */
    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }


    /**
     * Gets the modifiedDate value for this NoticeSoap.
     * 
     * @return modifiedDate
     */
    public java.util.Calendar getModifiedDate() {
        return modifiedDate;
    }


    /**
     * Sets the modifiedDate value for this NoticeSoap.
     * 
     * @param modifiedDate
     */
    public void setModifiedDate(java.util.Calendar modifiedDate) {
        this.modifiedDate = modifiedDate;
    }


    /**
     * Gets the noticeId value for this NoticeSoap.
     * 
     * @return noticeId
     */
    public long getNoticeId() {
        return noticeId;
    }


    /**
     * Sets the noticeId value for this NoticeSoap.
     * 
     * @param noticeId
     */
    public void setNoticeId(long noticeId) {
        this.noticeId = noticeId;
    }


    /**
     * Gets the primaryKey value for this NoticeSoap.
     * 
     * @return primaryKey
     */
    public long getPrimaryKey() {
        return primaryKey;
    }


    /**
     * Sets the primaryKey value for this NoticeSoap.
     * 
     * @param primaryKey
     */
    public void setPrimaryKey(long primaryKey) {
        this.primaryKey = primaryKey;
    }


    /**
     * Gets the taskId value for this NoticeSoap.
     * 
     * @return taskId
     */
    public java.lang.String getTaskId() {
        return taskId;
    }


    /**
     * Sets the taskId value for this NoticeSoap.
     * 
     * @param taskId
     */
    public void setTaskId(java.lang.String taskId) {
        this.taskId = taskId;
    }


    /**
     * Gets the title value for this NoticeSoap.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this NoticeSoap.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the type value for this NoticeSoap.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this NoticeSoap.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the url value for this NoticeSoap.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this NoticeSoap.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }


    /**
     * Gets the userId value for this NoticeSoap.
     * 
     * @return userId
     */
    public long getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this NoticeSoap.
     * 
     * @param userId
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }


    /**
     * Gets the userName value for this NoticeSoap.
     * 
     * @return userName
     */
    public java.lang.String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this NoticeSoap.
     * 
     * @param userName
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }


    /**
     * Gets the uuid value for this NoticeSoap.
     * 
     * @return uuid
     */
    public java.lang.String getUuid() {
        return uuid;
    }


    /**
     * Sets the uuid value for this NoticeSoap.
     * 
     * @param uuid
     */
    public void setUuid(java.lang.String uuid) {
        this.uuid = uuid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NoticeSoap)) return false;
        NoticeSoap other = (NoticeSoap) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.classNameId == other.getClassNameId() &&
            this.classPK == other.getClassPK() &&
            this.companyId == other.getCompanyId() &&
            this.completed == other.isCompleted() &&
            ((this.content==null && other.getContent()==null) || 
             (this.content!=null &&
              this.content.equals(other.getContent()))) &&
            ((this.createDate==null && other.getCreateDate()==null) || 
             (this.createDate!=null &&
              this.createDate.equals(other.getCreateDate()))) &&
            this.groupId == other.getGroupId() &&
            ((this.modifiedDate==null && other.getModifiedDate()==null) || 
             (this.modifiedDate!=null &&
              this.modifiedDate.equals(other.getModifiedDate()))) &&
            this.noticeId == other.getNoticeId() &&
            this.primaryKey == other.getPrimaryKey() &&
            ((this.taskId==null && other.getTaskId()==null) || 
             (this.taskId!=null &&
              this.taskId.equals(other.getTaskId()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl()))) &&
            this.userId == other.getUserId() &&
            ((this.userName==null && other.getUserName()==null) || 
             (this.userName!=null &&
              this.userName.equals(other.getUserName()))) &&
            ((this.uuid==null && other.getUuid()==null) || 
             (this.uuid!=null &&
              this.uuid.equals(other.getUuid())));
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
        _hashCode += new Long(getClassNameId()).hashCode();
        _hashCode += new Long(getClassPK()).hashCode();
        _hashCode += new Long(getCompanyId()).hashCode();
        _hashCode += (isCompleted() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getContent() != null) {
            _hashCode += getContent().hashCode();
        }
        if (getCreateDate() != null) {
            _hashCode += getCreateDate().hashCode();
        }
        _hashCode += new Long(getGroupId()).hashCode();
        if (getModifiedDate() != null) {
            _hashCode += getModifiedDate().hashCode();
        }
        _hashCode += new Long(getNoticeId()).hashCode();
        _hashCode += new Long(getPrimaryKey()).hashCode();
        if (getTaskId() != null) {
            _hashCode += getTaskId().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        _hashCode += new Long(getUserId()).hashCode();
        if (getUserName() != null) {
            _hashCode += getUserName().hashCode();
        }
        if (getUuid() != null) {
            _hashCode += getUuid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NoticeSoap.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.portal.wjxy.nci.com", "NoticeSoap"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("classNameId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "classNameId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("classPK");
        elemField.setXmlName(new javax.xml.namespace.QName("", "classPK"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("companyId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "companyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("completed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "completed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("groupId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modifiedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modifiedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noticeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "noticeId"));
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
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uuid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "uuid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
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
