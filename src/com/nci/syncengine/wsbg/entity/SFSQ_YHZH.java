package com.nci.syncengine.wsbg.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SFSQ_YHZH")
public class SFSQ_YHZH {
	@Id
	protected String ID;// char(32) 编号
	protected String YHBH;// char(8) 用户编号
	protected String XM;// varchar(50) 姓名
	protected String MM;// varchar(50) 加密密码（不可逆）
	protected String YHZH;// varchar(20) 用户账号
	protected String BGXTZH;// varchar(20) 备用账号
	protected String RYXH;// varchar(22) 人员序号
	protected String YHLB;// char(1) 用户类别
	protected Integer YHJBID;// int 用户级别ID
	protected String ZZMM;// char(2) 政治面貌
	protected String MZ;// char(2) 民族
	protected Date CSRQ;// datetime 出生日期
	protected String XB;// char(1) 性别
	protected String JZID;// varchar(8) 警种ID
	protected String JXID;// varchar(8) 警衔ID
	protected String ZWID;// varchar(8) 职务ID
	protected String GWID;// varchar(8) 岗位ID
	protected String SSDW;// varchar(20) 所属单位
	protected String SSJG;// varchar(20) 所属机构
	protected String ZGDW;// char(5) 主管单位(原)
	protected String BMBM;// char(5) 部门编码(原)
	protected String YHZT;// Char(1) 用户状态：‘1’代表有效 ‘3’用户注销

	protected String GWQY;// char(1) 公文权限
	protected String SFZT;// char(1) 是否暂停
	protected String ZZDH;// varchar(50) 工作电话
	protected String JTDH;// varchar(50) 家庭电话
	protected String SJHM;// varchar(50) 手机号码
	protected String YXZH;// varchar(20) 邮箱账号
	protected String XNH;// varchar(50) 虚拟号
	protected Integer YJFJDX;// int 邮件附件大小
	protected String AddAcc;// varchar(20) 创建人ID
	protected String AddAccName;// varchar(50) 创建人姓名
	protected Date AddTime;// datetime 创建时间
	protected String AddIP;// varchar(50) 创建人IP
	protected String ChgAcc;// varchar(20) 修改人ID
	protected String ChgAccName;// varchar(50) 修改人名称
	protected Date ChgTime;// datetime 修改时间
	protected String ChgIP;// varchar(50) 修改人IP
	protected boolean Deleted;// char(1) 删除标记
	protected boolean FLAG0;// char(1) 是否公文成员
	protected boolean FLAG1;// char(1) 是否驾驶员
	protected boolean YJXSBJ;// char(1) 邮件显示标记
	protected boolean TXLXSBJ;// char(1) 通讯录显示标记
	protected boolean DXFSBJ;// char(1) 短信发送标记
	protected boolean SFZW;// char(1) 是否在位
	protected Integer WJDX;// Int 文件大小
	protected String RYZT;// char(1) 人员状态

	protected Integer QSL;// Int 即时通讯群创建数
	protected Integer CYQSL;// Int 群参与数
	protected Integer QCYS;// Int 群人员数
	protected Integer TXWJDX;// Int 即时通讯文件大小
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getYHBH() {
		return YHBH;
	}
	public void setYHBH(String yHBH) {
		YHBH = yHBH;
	}
	public String getXM() {
		return XM;
	}
	public void setXM(String xM) {
		XM = xM;
	}
	public String getMM() {
		return MM;
	}
	public void setMM(String mM) {
		MM = mM;
	}
	public String getYHZH() {
		return YHZH;
	}
	public void setYHZH(String yHZH) {
		YHZH = yHZH;
	}
	public String getBGXTZH() {
		return BGXTZH;
	}
	public void setBGXTZH(String bGXTZH) {
		BGXTZH = bGXTZH;
	}
	public String getRYXH() {
		return RYXH;
	}
	public void setRYXH(String rYXH) {
		RYXH = rYXH;
	}
	public String getYHLB() {
		return YHLB;
	}
	public void setYHLB(String yHLB) {
		YHLB = yHLB;
	}
	public Integer getYHJBID() {
		return YHJBID;
	}
	public void setYHJBID(Integer yHJBID) {
		YHJBID = yHJBID;
	}
	public String getZZMM() {
		return ZZMM;
	}
	public void setZZMM(String zZMM) {
		ZZMM = zZMM;
	}
	public String getMZ() {
		return MZ;
	}
	public void setMZ(String mZ) {
		MZ = mZ;
	}
	public Date getCSRQ() {
		return CSRQ;
	}
	public void setCSRQ(Date cSRQ) {
		CSRQ = cSRQ;
	}
	public String getXB() {
		return XB;
	}
	public void setXB(String xB) {
		XB = xB;
	}
	public String getJZID() {
		return JZID;
	}
	public void setJZID(String jZID) {
		JZID = jZID;
	}
	public String getJXID() {
		return JXID;
	}
	public void setJXID(String jXID) {
		JXID = jXID;
	}
	public String getZWID() {
		return ZWID;
	}
	public void setZWID(String zWID) {
		ZWID = zWID;
	}
	public String getGWID() {
		return GWID;
	}
	public void setGWID(String gWID) {
		GWID = gWID;
	}
	public String getSSDW() {
		return SSDW;
	}
	public void setSSDW(String sSDW) {
		SSDW = sSDW;
	}
	public String getSSJG() {
		return SSJG;
	}
	public void setSSJG(String sSJG) {
		SSJG = sSJG;
	}
	public String getZGDW() {
		return ZGDW;
	}
	public void setZGDW(String zGDW) {
		ZGDW = zGDW;
	}
	public String getBMBM() {
		return BMBM;
	}
	public void setBMBM(String bMBM) {
		BMBM = bMBM;
	}
	public String getYHZT() {
		return YHZT;
	}
	public void setYHZT(String yHZT) {
		YHZT = yHZT;
	}
	public String getGWQY() {
		return GWQY;
	}
	public void setGWQY(String gWQY) {
		GWQY = gWQY;
	}
	public String getSFZT() {
		return SFZT;
	}
	public void setSFZT(String sFZT) {
		SFZT = sFZT;
	}
	public String getZZDH() {
		return ZZDH;
	}
	public void setZZDH(String zZDH) {
		ZZDH = zZDH;
	}
	public String getJTDH() {
		return JTDH;
	}
	public void setJTDH(String jTDH) {
		JTDH = jTDH;
	}
	public String getSJHM() {
		return SJHM;
	}
	public void setSJHM(String sJHM) {
		SJHM = sJHM;
	}
	public String getYXZH() {
		return YXZH;
	}
	public void setYXZH(String yXZH) {
		YXZH = yXZH;
	}
	public String getXNH() {
		return XNH;
	}
	public void setXNH(String xNH) {
		XNH = xNH;
	}
	public Integer getYJFJDX() {
		return YJFJDX;
	}
	public void setYJFJDX(Integer yJFJDX) {
		YJFJDX = yJFJDX;
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
	public boolean isDeleted() {
		return Deleted;
	}
	public void setDeleted(boolean deleted) {
		Deleted = deleted;
	}
	public boolean isFLAG0() {
		return FLAG0;
	}
	public void setFLAG0(boolean fLAG0) {
		FLAG0 = fLAG0;
	}
	public boolean isFLAG1() {
		return FLAG1;
	}
	public void setFLAG1(boolean fLAG1) {
		FLAG1 = fLAG1;
	}
	public boolean isYJXSBJ() {
		return YJXSBJ;
	}
	public void setYJXSBJ(boolean yJXSBJ) {
		YJXSBJ = yJXSBJ;
	}
	public boolean isTXLXSBJ() {
		return TXLXSBJ;
	}
	public void setTXLXSBJ(boolean tXLXSBJ) {
		TXLXSBJ = tXLXSBJ;
	}
	public boolean isDXFSBJ() {
		return DXFSBJ;
	}
	public void setDXFSBJ(boolean dXFSBJ) {
		DXFSBJ = dXFSBJ;
	}
	public boolean isSFZW() {
		return SFZW;
	}
	public void setSFZW(boolean sFZW) {
		SFZW = sFZW;
	}
	public Integer getWJDX() {
		return WJDX;
	}
	public void setWJDX(Integer wJDX) {
		WJDX = wJDX;
	}
	public String getRYZT() {
		return RYZT;
	}
	public void setRYZT(String rYZT) {
		RYZT = rYZT;
	}
	public Integer getQSL() {
		return QSL;
	}
	public void setQSL(Integer qSL) {
		QSL = qSL;
	}
	public Integer getCYQSL() {
		return CYQSL;
	}
	public void setCYQSL(Integer cYQSL) {
		CYQSL = cYQSL;
	}
	public Integer getQCYS() {
		return QCYS;
	}
	public void setQCYS(Integer qCYS) {
		QCYS = qCYS;
	}
	public Integer getTXWJDX() {
		return TXWJDX;
	}
	public void setTXWJDX(Integer tXWJDX) {
		TXWJDX = tXWJDX;
	}
	
	
	
	
	

}
