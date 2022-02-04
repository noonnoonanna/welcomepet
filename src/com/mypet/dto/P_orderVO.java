package com.mypet.dto;

import java.sql.Timestamp;

public class P_orderVO {
	private int odNum; 
	private int oNum;
	private String ID; 
	private Timestamp indate;
	private	int pNum;
	private int cnt;
	private String name;
	private String address;
	private String phone;
	private String pName;
	private	int pPrice;
	private String user_state;
	private String admin_state;
	private String oname;
	private String oaddress;
	private String ophone;
	private int rank;
	private String catename;

	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getOaddress() {
		return oaddress;
	}
	public void setOaddress(String oaddress) {
		this.oaddress = oaddress;
	}
	public String getOphone() {
		return ophone;
	}
	public void setOphone(String ophone) {
		this.ophone = ophone;
	}
	private int result;


	public int getOdNum() {
		return odNum;
	}
	public void setOdNum(int odNum) {
		this.odNum = odNum;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getoNum() {
		return oNum;
	}
	public void setoNum(int oNum) {
		this.oNum = oNum;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public String getUser_state() {
		return user_state;
	}
	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}
	public String getAdmin_state() {
		return admin_state;
	}
	public void setAdmin_state(String admin_state) {
		this.admin_state = admin_state;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}
	public String getCatename() {
		return catename;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return "P_orderVO [odNum=" + odNum + ", oNum=" + oNum + ", ID=" + ID + ", indate=" + indate + ", pNum=" + pNum
				+ ", cnt=" + cnt + ", name=" + name + ", address=" + address + ", phone=" + phone + ", pName=" + pName
				+ ", pPrice=" + pPrice + ", user_state=" + user_state + ", admin_state=" + admin_state + ", oname="
				+ oname + ", oaddress=" + oaddress + ", ophone=" + ophone + ", rank=" + rank + ", catename=" + catename
				+ ", result=" + result + "]";
	}
}
