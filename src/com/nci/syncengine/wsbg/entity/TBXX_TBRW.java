package com.nci.syncengine.wsbg.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "TBXX_TBRW")
public class TBXX_TBRW {
	@Id
	private  Integer	ID	;//Bigint	自增编号
	private  String	BM	;//varchar(50)	待同步数据对应表名
	private  String	BID	;//varchar(50)	待同步数据主键ID
	private  Date	SJ	;//datetime	添加时间
	private  String	LX	;//char(1)	“i”表示新增（insert） “u”表示修改(update)  “d”表示删除(delete)
	private  String	ZT	;//char(1)	状态 默认为0
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getBM() {
		return BM;
	}
	public void setBM(String bM) {
		BM = bM;
	}
	public String getBID() {
		return BID;
	}
	public void setBID(String bID) {
		BID = bID;
	}
	public Date getSJ() {
		return SJ;
	}
	public void setSJ(Date sJ) {
		SJ = sJ;
	}
	public String getLX() {
		return LX;
	}
	public void setLX(String lX) {
		LX = lX;
	}
	public String getZT() {
		return ZT;
	}
	public void setZT(String zT) {
		ZT = zT;
	}
	@Override
	public String toString() {
		return "TBXX_TBRW [ID=" + ID + ", BM=" + BM + ", BID=" + BID + ", SJ="
				+ SJ + ", LX=" + LX + ", ZT=" + ZT + "]";
	}


}
