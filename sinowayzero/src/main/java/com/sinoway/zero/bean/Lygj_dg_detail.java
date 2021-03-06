package com.sinoway.zero.bean;

import java.sql.Date;
import java.sql.Timestamp;

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
	private Timestamp createdate;
	@Column(name="dgtype")
	private String dgtype;
	public Lygj_dg_detail(){}
	public  Lygj_dg_detail(String s,String n,String tc,Timestamp c,String dg){
		this.sphone=s;
		this.nphone=n;
		this.tcmoney=tc;
		this.createdate=c;
		this.dgtype=dg;
	}
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
	public Timestamp getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Timestamp time) {
		this.createdate = time;
	}
	public String getDgtype() {
		return dgtype;
	}
	public void setDgtype(String dgtype) {
		this.dgtype = dgtype;
	}
	
	
}
