package com.mypet.dto;

import java.sql.Timestamp;

public class ReviewVO {
	 private int rNum;
	 private String ID;
	 private String content;
	 private String rImg;
	 private Timestamp wDate;
	 private String rating;
	 private int pNum;
	 private int odNum;
	 private String USER_STATE;
	 
	public int getrNum() {
		return rNum;
	}
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getrImg() {
		return rImg;
	}
	public void setrImg(String rImg) {
		this.rImg = rImg;
	}
	public Timestamp getwDate() {
		return wDate;
	}
	public void setwDate(Timestamp wDate) {
		this.wDate = wDate;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public String getUSER_STATE() {
		return USER_STATE;
	}
	public void setUSER_STATE(String uSER_STATE) {
		USER_STATE = uSER_STATE;
	}
	public int getOdNum() {
		return odNum;
	}
	public void setOdNum(int odNum) {
		this.odNum = odNum;
	}
	@Override
	public String toString() {
		return "ReviewVO [rNum=" + rNum + ", ID=" + ID + ", content=" + content + ", rImg=" + rImg + ", wDate=" + wDate
				+ ", rating=" + rating + ", pNum=" + pNum + ", odNum=" + odNum + ", USER_STATE=" + USER_STATE + "]";
	}
	
	
}
