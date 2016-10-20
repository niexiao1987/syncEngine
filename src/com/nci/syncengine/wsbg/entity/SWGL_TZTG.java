package com.nci.syncengine.wsbg.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "SWGL_TZTG")
public class SWGL_TZTG {
	@Id
	private String ID	;//编号（Guid.NewGuid().ToString().Replace("-", "").ToUpper()）
	private String SSDW	;//所属单位
	private String LB	;//类别
	private String BT	;//	标题
	private Date FBRQ	;//发布日期
	private String FBBM	;//	发布部门
	private String QFR	;//签发人
	private String QFRQ	;//签发日期
	private String CBR	;//承办人
	private String NR	;//内容
	private Date YXRQ	;//有效日期
	private String NRLB	;//内容类别
	private String SFGD	;//是否滚动
	private String AddAcc	  ;//创建人ID
	private String AddAccName;//创建人姓名
	private String AddIP	 ;//创建人IP
	private Date AddTime	  ;//创建时间
	private String ChgAccName;//修改人姓名
	private String ChgAcc	  ;//修改人ID
	private String ChgIP	 ;//修改人IP
	private String ChgTime	  ;//修改时间
	private String Deleted	  ;//删除标记
	private String JJCD	      ;//紧急程度
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getSSDW() {
		return SSDW;
	}
	public void setSSDW(String sSDW) {
		SSDW = sSDW;
	}
	public String getLB() {
		return LB;
	}
	public void setLB(String lB) {
		LB = lB;
	}
	public String getBT() {
		return BT;
	}
	public void setBT(String bT) {
		BT = bT;
	}
	public Date getFBRQ() {
		return FBRQ;
	}
	public void setFBRQ(Date fBRQ) {
		FBRQ = fBRQ;
	}
	public String getFBBM() {
		return FBBM;
	}
	public void setFBBM(String fBBM) {
		FBBM = fBBM;
	}
	public String getQFR() {
		return QFR;
	}
	public void setQFR(String qFR) {
		QFR = qFR;
	}
	public String getQFRQ() {
		return QFRQ;
	}
	public void setQFRQ(String qFRQ) {
		QFRQ = qFRQ;
	}
	public String getCBR() {
		return CBR;
	}
	public void setCBR(String cBR) {
		CBR = cBR;
	}
	public String getNR() {
		return NR;
	}
	public void setNR(String nR) {
		NR = nR;
	}
	public Date getYXRQ() {
		return YXRQ;
	}
	public void setYXRQ(Date yXRQ) {
		YXRQ = yXRQ;
	}
	public String getNRLB() {
		return NRLB;
	}
	public void setNRLB(String nRLB) {
		NRLB = nRLB;
	}
	public String getSFGD() {
		return SFGD;
	}
	public void setSFGD(String sFGD) {
		SFGD = sFGD;
	}

	public String getAddAcc() {
		return AddAcc;
	}
	public void setAddAcc(String addAcc) {
		AddAcc = addAcc;
	}
	public String getAddAccName() {
		return AddAccName;
	}
	public void setAddAccName(String addAccName) {
		AddAccName = addAccName;
	}
	public String getAddIP() {
		return AddIP;
	}
	public void setAddIP(String addIP) {
		AddIP = addIP;
	}
	public Date getAddTime() {
		return AddTime;
	}
	public void setAddTime(Date addTime) {
		AddTime = addTime;
	}
	public String getChgAccName() {
		return ChgAccName;
	}
	public void setChgAccName(String chgAccName) {
		ChgAccName = chgAccName;
	}
	public String getChgAcc() {
		return ChgAcc;
	}
	public void setChgAcc(String chgAcc) {
		ChgAcc = chgAcc;
	}
	public String getChgIP() {
		return ChgIP;
	}
	public void setChgIP(String chgIP) {
		ChgIP = chgIP;
	}
	public String getChgTime() {
		return ChgTime;
	}
	public void setChgTime(String chgTime) {
		ChgTime = chgTime;
	}
	public String getDeleted() {
		return Deleted;
	}
	public void setDeleted(String deleted) {
		Deleted = deleted;
	}
	public String getJJCD() {
		return JJCD;
	}
	public void setJJCD(String jJCD) {
		JJCD = jJCD;
	}
	@Override
	public String toString() {
		return "SWGL_TZTG [ID=" + ID + ", SSDW=" + SSDW + ", LB=" + LB
				+ ", BT=" + BT + ", FBRQ=" + FBRQ + ", FBBM=" + FBBM + ", QFR="
				+ QFR + ", QFRQ=" + QFRQ + ", CBR=" + CBR + ", NR=" + NR
				+ ", YXRQ=" + YXRQ + ", NRLB=" + NRLB + ", SFGD=" + SFGD
				+ ",  AddAcc=" + AddAcc + ", AddAccName="
				+ AddAccName + ", AddIP=" + AddIP + ", AddTime=" + AddTime
				+ ", ChgAccName=" + ChgAccName + ", ChgAcc=" + ChgAcc
				+ ", ChgIP=" + ChgIP + ", ChgTime=" + ChgTime + ", Deleted="
				+ Deleted + ", JJCD=" + JJCD + "]";
	}
	
	
}
