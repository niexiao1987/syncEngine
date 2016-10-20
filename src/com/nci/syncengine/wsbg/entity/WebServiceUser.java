package com.nci.syncengine.wsbg.entity;

public class WebServiceUser {
	private String DATAVERSION;//版本号
	private String LOGINID;//登录账号
	private String JGMC;//部门
	private String STATUS;//状态
	private String XM;//姓名
	public String getDATAVERSION() {
		return DATAVERSION;
	}
	public void setDATAVERSION(String dATAVERSION) {
		DATAVERSION = dATAVERSION;
	}
	public String getLOGINID() {
		return LOGINID;
	}
	public void setLOGINID(String lOGINID) {
		LOGINID = lOGINID;
	}
	public String getJGMC() {
		return JGMC;
	}
	public void setJGMC(String jGMC) {
		JGMC = jGMC;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getXM() {
		return XM;
	}
	public void setXM(String xM) {
		XM = xM;
	}
	@Override
	public String toString() {
		return "WebServiceUser [DATAVERSION=" + DATAVERSION + ", LOGINID="
				+ LOGINID + ", JGMC=" + JGMC + ", STATUS=" + STATUS + ", XM="
				+ XM + "]";
	}
	
	
	
	
}
