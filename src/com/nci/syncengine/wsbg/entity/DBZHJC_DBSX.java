package com.nci.syncengine.wsbg.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "DBZHJC_DBSX")
public class DBZHJC_DBSX {
	@Id
	private String ID;           //编号
	private String YWXTBM;       //业务系统编码
	private String SPLXBH;       //审批类型编号
	private Integer SPID;        //审批编号
	private Integer LZID;        //流转编号
	private String YID;          //源ID
	private String SJRID;        //收件人ID
	private String SJRXM;        //收件人姓名
	private String SFCL;         //待办显示类型(0：按人员编号显示  1：按权限显示)
	private String SOJRID;       //送件人ID
	private String SOJRXM;       //送件人姓名
	private Date SJSJ;           //送达时间
	private String BT;           //标题
	private String BTLJ;         //标题链接
	private String CZBT;         //操作标题
	private String CZBTLJ;       //操作标题链接
	private String AddAcc;       //创建人ID
	private String AddAccName;   //创建人姓名
	private Date AddTime;        //创建时间
	private String AddIP;        //创建人IP
	private String ChgAcc;       //修改人ID
	private String ChgAccName;   //修改人姓名
	private Date ChgTime;        //修改时间
	private String ChgIP;        //修改人IP
	private String Deleted;      //删除标记
	private String SSDW;         //所属单位
	private String LSLX;         //铃声类型
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getYWXTBM() {
		return YWXTBM;
	}
	public void setYWXTBM(String yWXTBM) {
		YWXTBM = yWXTBM;
	}
	public String getSPLXBH() {
		return SPLXBH;
	}
	public void setSPLXBH(String sPLXBH) {
		SPLXBH = sPLXBH;
	}
	public Integer getSPID() {
		return SPID;
	}
	public void setSPID(Integer sPID) {
		SPID = sPID;
	}
	public Integer getLZID() {
		return LZID;
	}
	public void setLZID(Integer lZID) {
		LZID = lZID;
	}
	public String getYID() {
		return YID;
	}
	public void setYID(String yID) {
		YID = yID;
	}
	public String getSJRID() {
		return SJRID;
	}
	public void setSJRID(String sJRID) {
		SJRID = sJRID;
	}
	public String getSJRXM() {
		return SJRXM;
	}
	public void setSJRXM(String sJRXM) {
		SJRXM = sJRXM;
	}
	public String getSFCL() {
		return SFCL;
	}
	public void setSFCL(String sFCL) {
		SFCL = sFCL;
	}
	public String getSOJRID() {
		return SOJRID;
	}
	public void setSOJRID(String sOJRID) {
		SOJRID = sOJRID;
	}
	public String getSOJRXM() {
		return SOJRXM;
	}
	public void setSOJRXM(String sOJRXM) {
		SOJRXM = sOJRXM;
	}
	public Date getSJSJ() {
		return SJSJ;
	}
	public void setSJSJ(Date sJSJ) {
		SJSJ = sJSJ;
	}
	public String getBT() {
		return BT;
	}
	public void setBT(String bT) {
		BT = bT;
	}
	public String getBTLJ() {
		return BTLJ;
	}
	public void setBTLJ(String bTLJ) {
		BTLJ = bTLJ;
	}
	public String getCZBT() {
		return CZBT;
	}
	public void setCZBT(String cZBT) {
		CZBT = cZBT;
	}
	public String getCZBTLJ() {
		return CZBTLJ;
	}
	public void setCZBTLJ(String cZBTLJ) {
		CZBTLJ = cZBTLJ;
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
	public Date getAddTime() {
		return AddTime;
	}
	public void setAddTime(Date addTime) {
		AddTime = addTime;
	}
	public String getAddIP() {
		return AddIP;
	}
	public void setAddIP(String addIP) {
		AddIP = addIP;
	}
	public String getChgAcc() {
		return ChgAcc;
	}
	public void setChgAcc(String chgAcc) {
		ChgAcc = chgAcc;
	}
	public String getChgAccName() {
		return ChgAccName;
	}
	public void setChgAccName(String chgAccName) {
		ChgAccName = chgAccName;
	}
	public Date getChgTime() {
		return ChgTime;
	}
	public void setChgTime(Date chgTime) {
		ChgTime = chgTime;
	}
	public String getChgIP() {
		return ChgIP;
	}
	public void setChgIP(String chgIP) {
		ChgIP = chgIP;
	}
	public String getDeleted() {
		return Deleted;
	}
	public void setDeleted(String deleted) {
		Deleted = deleted;
	}
	public String getSSDW() {
		return SSDW;
	}
	public void setSSDW(String sSDW) {
		SSDW = sSDW;
	}
	public String getLSLX() {
		return LSLX;
	}
	public void setLSLX(String lSLX) {
		LSLX = lSLX;
	}
	@Override
	public String toString() {
		return "DBZHJC_DBSX [ID=" + ID + ", YWXTBM=" + YWXTBM + ", SPLXBH="
				+ SPLXBH + ", SPID=" + SPID + ", LZID=" + LZID + ", YID=" + YID
				+ ", SJRID=" + SJRID + ", SJRXM=" + SJRXM + ", SFCL=" + SFCL
				+ ", SOJRID=" + SOJRID + ", SOJRXM=" + SOJRXM + ", SJSJ="
				+ SJSJ + ", BT=" + BT + ", BTLJ=" + BTLJ + ", CZBT=" + CZBT
				+ ", CZBTLJ=" + CZBTLJ + ", AddAcc=" + AddAcc + ", AddAccName="
				+ AddAccName + ", AddTime=" + AddTime + ", AddIP=" + AddIP
				+ ", ChgAcc=" + ChgAcc + ", ChgAccName=" + ChgAccName
				+ ", ChgTime=" + ChgTime + ", ChgIP=" + ChgIP + ", Deleted="
				+ Deleted + ", SSDW=" + SSDW + ", LSLX=" + LSLX + "]";
	}
	
	
	
}
