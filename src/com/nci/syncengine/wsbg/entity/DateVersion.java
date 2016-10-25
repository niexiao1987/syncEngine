package com.nci.syncengine.wsbg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBXX_SYNCDATAVERSION")

public class DateVersion {
	@Id
	@Column(name="YWCODE")
	private String ywCode;
	@Column(name="DATAVERSION")
	private Long dataversion;
	public String getYwCode() {
		return ywCode;
	}
	public void setYwCode(String ywCode) {
		this.ywCode = ywCode;
	}
	public Long getDataversion() {
		return dataversion;
	}
	public void setDataversion(Long dataversion) {
		this.dataversion = dataversion;
	}
	@Override
	public String toString() {
		return "DateVersion [ywCode=" + ywCode + ", dataversion=" + dataversion
				+ "]";
	}
	
	
	
	
}
