package com.mypet.dto;

public class Join_UserVO {
	private String ID;		
	private String password;
	private String name; 	
	private String birthday;
	private String phone; 	
	private String address; 
	private String Email;
	private String cateName;
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		return "Join_UserVO [ID=" + ID + ", password=" + password + ", name=" + name + ", birthday=" + birthday
				+ ", phone=" + phone + ", address=" + address + ", Email=" + Email + ", cateName=" + cateName + "]";
	}
	
	
}
