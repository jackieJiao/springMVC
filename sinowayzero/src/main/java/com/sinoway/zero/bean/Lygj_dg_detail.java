package com.sinoway.zero.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lygj_dg_detail")
public class Lygj_dg_detail {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="sphone")
	private String sphone;
	@Column(name="nphone")
	private String nphone;
	@Column(name="tcmoney")
	private String tcmoney;
	@Column(name="createdate")
	private String createdate;
	@Column(name="dgtype")
	private String dgtype;
	//getter & setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getNphone() {
		return nphone;
	}
	public void setNphone(String nphone) {
		this.nphone = nphone;
	}
	public String getTcmoney() {
		return tcmoney;
	}
	public void setTcmoney(String tcmoney) {
		this.tcmoney = tcmoney;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getDgtype() {
		return dgtype;
	}
	public void setDgtype(String dgtype) {
		this.dgtype = dgtype;
	}
	
	
}
