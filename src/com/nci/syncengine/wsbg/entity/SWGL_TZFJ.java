package com.nci.syncengine.wsbg.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "SWGL_TZFJ")
public class SWGL_TZFJ {
	@Id
	private String ID	;//编号（Guid.NewGuid().ToString().Replace("-", "").ToUpper()）
	private String TZID	;//通知ID
	private String FJDZ	;//	附件地址。只保留通知通告附件日期和名称的地址，例如：（201012\7fc1aa86d85643b9b1f3a121a6cfe10e.doc）
	private String FJDX	;//附件大小
	private String FJLX	;//附件类型
	private String FJBDMC;//	附件本地名称
	private String PXH	;//排序号
	private String KZM	;//附件扩展名
	private String WJLB	;//文件类别
	private String WJNR	;//	文件内容
	private String WJCD	;//文件长度
	private String AddAccName	;//	创建人姓名
	private String AddAcc	;//	创建人ID
	private Date AddTime	;//	创建时间
	private String AddIP	;//	创建人IP
	private String ChgAccName	;//	修改人姓名
	private String ChgAcc	;//	修改人ID
	private Date ChgTime	;//	修改时间
	private String ChgIP	;//	修改人IP
	private String Deleted	;//删除标记
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTZID() {
		return TZID;
	}
	public void setTZID(String tZID) {
		TZID = tZID;
	}
	public String getFJDZ() {
		return FJDZ;
	}
	public void setFJDZ(String fJDZ) {
		FJDZ = fJDZ;
	}
	public String getFJDX() {
		return FJDX;
	}
	public void setFJDX(String fJDX) {
		FJDX = fJDX;
	}
	public String getFJLX() {
		return FJLX;
	}
	public void setFJLX(String fJLX) {
		FJLX = fJLX;
	}
	public String getFJBDMC() {
		return FJBDMC;
	}
	public void setFJBDMC(String fJBDMC) {
		FJBDMC = fJBDMC;
	}
	public String getPXH() {
		return PXH;
	}
	public void setPXH(String pXH) {
		PXH = pXH;
	}
	public String getKZM() {
		return KZM;
	}
	public void setKZM(String kZM) {
		KZM = kZM;
	}
	public String getWJLB() {
		return WJLB;
	}
	public void setWJLB(String wJLB) {
		WJLB = wJLB;
	}
	public String getWJNR() {
		return WJNR;
	}
	public void setWJNR(String wJNR) {
		WJNR = wJNR;
	}
	public String getWJCD() {
		return WJCD;
	}
	public void setWJCD(String wJCD) {
		WJCD = wJCD;
	}
	public String getAddAccName() {
		return AddAccName;
	}
	public void setAddAccName(String addAccName) {
		AddAccName = addAccName;
	}
	public String getAddAcc() {
		return AddAcc;
	}
	public void setAddAcc(String addAcc) {
		AddAcc = addAcc;
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
	@Override
	public String toString() {
		return "SWGL_TZFJ [ID=" + ID + ", TZID=" + TZID + ", FJDZ=" + FJDZ
				+ ", FJDX=" + FJDX + ", FJLX=" + FJLX + ", FJBDMC=" + FJBDMC
				+ ", PXH=" + PXH + ", KZM=" + KZM + ", WJLB=" + WJLB
				+ ", WJNR=" + WJNR + ", WJCD=" + WJCD + ", AddAccName="
				+ AddAccName + ", AddAcc=" + AddAcc + ", AddTime=" + AddTime
				+ ", AddIP=" + AddIP + ", ChgAccName=" + ChgAccName
				+ ", ChgAcc=" + ChgAcc + ", ChgTime=" + ChgTime + ", ChgIP="
				+ ChgIP + ", Deleted=" + Deleted + "]";
	}
	
	
}
